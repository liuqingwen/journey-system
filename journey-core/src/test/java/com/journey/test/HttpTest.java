package com.journey.test;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

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

}
