package com.journey.demo.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liuqingwen
 * @date 2018/10/19.
 */
//@org.springframework.stereotype.Service
@Service(version = "1.0", group = "direct")
public class UserService implements IUserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Override
    public String getUserName(String no) {
        LOGGER.info("UserService#getUserName({})", no);
        return "你好";
    }
}
