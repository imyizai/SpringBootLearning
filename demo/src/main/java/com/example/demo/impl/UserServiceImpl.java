package com.example.demo.impl;

import com.example.demo.Dao.UserDAO;
import com.example.demo.Service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imyizai
 * @ClassName UserServiceImpl
 * @Description
 * @Date 2021/3/18 2:37 下午
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        // 这里我们就可以直接使用 findAll 方法
        return userDAO.findAll();
    }
}