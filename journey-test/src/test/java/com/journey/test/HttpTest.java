package com.journey.test;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by liuqingwen on 2017/10/10.
 */
public class HttpTest {

    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody requestBody = new FormBody.Builder(Charset.defaultCharset())
                .add("city", "beijing")
                .add("key", "95c944325dfa427d836b3a32875d1b77")
                .build();
//                ormBody.create(mediaType, " city=beijing&key=95c944325dfa427d836b3a32875d1b77");

//        Request request = new Request.Builder()
//                .url("https://free-api.heweather.com/v5/weather")
//                .post(requestBody).build();


        Request request = new Request.Builder()
                .url("https://free-api.heweather.com/v5/weather?city=beijing&key=95c944325dfa427d836b3a32875d1b77").get().build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("access_token", "2.00TtoPUDZywM3Bba3ca0c8aaR6a7xD")
                .build();
        Response response = okHttpClient.newCall(new Request.Builder().post(requestBody).url("https://api.weibo.com/oauth2/get_token_info").build()).execute();
        String returnV = response == null ? null : JSON.toJSONString(response.body().string());
        System.out.println(returnV);
        System.out.println(returnV);

    }

    ExecutorService executorService = Executors.newFixedThreadPool(100 * Runtime.getRuntime().availableProcessors() * 2);

    @Test
    public void test2() throws IOException {

//        http();

        IntStream.range(0, 5).forEach(v -> executorService.execute(() -> {
            try {
                http();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        Object lock = new Object();
        synchronized (lock) {
            while (true) {
                System.out.println("--------------------");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    OkHttpClient okHttpClient = new OkHttpClient();
    private void http() throws IOException {

        RequestBody requestBody = new FormBody.Builder().add("activityId", "3343a791-a623-428a-95db-cc38ce6f37e1")
                .add("mobile", "18744034293").add("verifyCode", "adds").build();

        Response response = okHttpClient.newCall(new Request.Builder().post(requestBody).url("https://test34mmarket.jiuxian.com/draw/getMobileVerifyCode").build()).execute();
        System.out.println(response == null ? null : JSON.toJSONString(response.body().string()));
    }

}
