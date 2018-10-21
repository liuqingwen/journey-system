package com.journey.demo.data.mapper;

import com.journey.demo.data.entity.LoginUserInfo;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public interface UserLoginMapper {

    LoginUserInfo getLoginUserInfo(String account);

}
