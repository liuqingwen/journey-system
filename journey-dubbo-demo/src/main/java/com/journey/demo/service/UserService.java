package com.journey.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.journey.demo.data.mapper.UserLoginMapper;
import com.journey.demo.entity.LoginUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuqingwen
 * @date 2018/10/19.
 */
//@org.springframework.stereotype.Service
@Service(version = "1.0", group = "direct")
public class UserService implements IUserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired private UserLoginMapper userLoginMapper;

    @Override
    public LoginUserInfo getUserName(String account) {
        LOGGER.info("UserService#getUserName({})", account);
        return userLoginMapper.getLoginUserInfo(account);
    }
}
