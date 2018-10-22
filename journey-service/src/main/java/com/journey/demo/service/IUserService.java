package com.journey.demo.service;

import com.journey.demo.entity.LoginUserInfo;

/**
 * @author liuqingwen
 * @date 2018/10/19.
 */
public interface IUserService {

    LoginUserInfo getUserName(String account);

}
