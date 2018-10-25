package com.journey.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.journey.demo.data.mapper.UserLoginMapper;
import com.journey.demo.entity.LoginUserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/10/19.
 */
//@org.springframework.stereotype.Service
@Service(version = "1.0", group = "direct")
public class UserService implements IUserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired private UserLoginMapper userLoginMapper;

    @Transactional(transactionManager = "platformTransactionManager", isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "200")
    }, fallbackMethod = "getDefaultUserName")
    @Override
    public LoginUserInfo getUserName(String account) {
        LOGGER.info("UserService#getUserName({})", account);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e) { }
        return userLoginMapper.getLoginUserInfo(account);
    }

    private LoginUserInfo getDefaultUserName(String account) {
        LOGGER.info("UserService#getDefaultUserName({})", account);
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setAccount("默认用户");
        return loginUserInfo;
    }
}
