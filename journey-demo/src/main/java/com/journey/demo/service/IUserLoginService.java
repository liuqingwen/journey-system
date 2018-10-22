package com.journey.demo.service;

import com.journey.demo.entity.LoginUserInfo;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public interface IUserLoginService {

    LoginUserInfo getLoginUserInfo(String account);

}
