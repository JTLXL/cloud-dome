package com.jtl.user.web;

import com.jtl.user.pojo.User;
import com.jtl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JT.L
 * @date 2020/2/22 18:05:23
 * @description
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("{id}")
    public User user(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
