package com.journey.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.journey.entity.WeiXinUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqingwen
 * @date 2017/11/3.
 */
public class JSONTest {

    public static void main(String[] args) {


        Map<String, Object> returnV = new HashMap<>();
        returnV.put("notPlayCouponTip", true);
        System.out.println(JSON.toJSONString(returnV));

    }

    @Test
    public void test() {

        String s = "{\"openid\":\"oiFRe0wUn6smdi18kUjTdWc3qt4Y\",\"nickname\":\"刘庆文\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"Chaoyang\",\"province\":\"Beijing\",\"country\":\"CN\",\"headimgurl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/vi_32\\/DYAIOgq83eo8aRo2keDReuwiaCSPCPAWtxUOrWMDQcMx4X1jrstflsviawNlWxCnBkibybTjHWTG0fNloVgm9C3Rw\\/0\",\"privilege\":[],\"unionid\":\"oa7aI0tQ1z8q9th9R1FOFzRklhOo\"}";
        WeiXinUser weiXinUser = JSON.parseObject(s, WeiXinUser.class);
        System.out.println(weiXinUser == null ? null : JSON.toJSON(weiXinUser));

    }

    @Test
    public void test2() {

        String s = "{\"openid\":\"oiFRe0wUn6smdi18kUjTdWc3qt4Y\",\"nickname\":\"刘庆文\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"Chaoyang\",\"province\":\"Beijing\",\"country\":\"CN\",\"headimgurl\":\"http:\\/\\/wx.qlogo.cn\\/mmopen\\/vi_32\\/DYAIOgq83eo8aRo2keDReuwiaCSPCPAWtxUOrWMDQcMx4X1jrstflsviawNlWxCnBkibybTjHWTG0fNloVgm9C3Rw\\/0\",\"privilege\":[],\"unionid\":\"oa7aI0tQ1z8q9th9R1FOFzRklhOo\"}";
        System.out.println(JSON.parseObject(s).getString("sdfa"));

    }

    @Test
    public void test3() {

        ArrayList<ImmutableMap<String, String>> immutableMaps = Lists.newArrayList(ImmutableMap.of("积分", "+10"), ImmutableMap.of("成长值", "+10"));
        System.out.println(JSON.toJSONString(immutableMaps));

    }

    @Test
    public void test4() {

        System.out.println(JSON.toJSONString(Lists.newArrayList(ImmutableMap.of("user", "liu"), ImmutableMap.of("user", "liu2"))));

    }

    @Test
    public void test5() {

        String arg = "{\"amount\":1,\"autoRenew\":3,\"chargeType\":1,\"endTime\":1560512350000,\"orderCode\":\"201905141939006432927\",\"productSubtype\":1,\"startTime\":1557833950000,\"status\":1,\"tradeCode\":\"4200000301201905143632645731\",\"uid\":1400096341}";
        System.out.println(JSON.parseObject(arg, new TypeReference<Map<String, Object>>(){}));

    }

    @Test
    public void test6() {

        System.out.println(2007897004L % 3);

    }

}
