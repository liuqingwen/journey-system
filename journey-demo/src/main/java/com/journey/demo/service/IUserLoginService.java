package com.journey.demo.service;

import com.journey.demo.data.entity.LoginUserInfo;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public interface IUserLoginService {

    LoginUserInfo getLoginUserInfo(String account);

}
