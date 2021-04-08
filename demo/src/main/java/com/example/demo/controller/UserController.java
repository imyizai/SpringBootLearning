package com.example.demo.controller;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author imyizai
 * @ClassName UserController
 * @Description
 * @Date 2021/3/18 2:40 下午
 **/
@RestController
public class UserController {

    @Autowired
    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> findAll() {

        return userService.findAll();
    }
}