package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @author: itXiaoKe
 * @date: 2020/2/24 15:48
 * @Description: no description
 * @Version: 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/loadLoginName")
    public Map<String, String> loadLoginName() {
        String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, String> map = new HashMap<>(0);
        map.put("loginName", loginName);
        return map;
    }
}
