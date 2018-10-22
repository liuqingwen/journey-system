package com.journey.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.journey.demo.service.IUserLoginService;
import com.journey.demo.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
    @Autowired private IUserLoginService userLoginService;
    @Reference(version = "1.0", group = "direct") private IUserService userService;

    @HystrixCommand(fallbackMethod = "login2")
    @ResponseBody
    @RequestMapping(value = "login.htm")
    public Object login(@RequestParam("acc") String account) {

        Object obj = userService.getUserName(account);

        return obj;
    }

    public Object login2(String account) {
        LOGGER.info("UserLoginController#login2({})", account);
        return "liu";
    }

}
