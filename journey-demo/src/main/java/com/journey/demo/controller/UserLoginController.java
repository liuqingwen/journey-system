package com.journey.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.journey.demo.service.IUserLoginService;
import com.journey.demo.service.IUserService;
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

    @Autowired private IUserLoginService userLoginService;
    @Reference(version = "1.0", group = "direct") private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "login.htm")
    public Object login(@RequestParam("acc") String account) {

        return userService.getUserName(account);
    }

}
