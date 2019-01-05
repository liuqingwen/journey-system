package com.journey.demo.service;

import com.journey.demo.entity.LoginUserInfo;
import com.journey.demo.data.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
@Service
public class UserLoginService implements IUserLoginService {

    @Autowired private UserLoginMapper userLoginMapper;

    @Override
    public LoginUserInfo getLoginUserInfo(String account) {
        return userLoginMapper.getLoginUserInfo(account);
    }
}
