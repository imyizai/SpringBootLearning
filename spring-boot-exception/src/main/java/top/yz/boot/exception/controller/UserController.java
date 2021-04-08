package top.yz.boot.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yz.boot.exception.entity.User;
import top.yz.boot.exception.service.ExceptionService;

import javax.annotation.Resource;

/**
 * @author imyizai
 * @ClassName UserController
 * @Description
 * @Date 2021/4/8 2:09 下午
 **/
@RestController
@RequestMapping("api/user")
public class UserController {
    @Resource
    private  ExceptionService exceptionService;

    @GetMapping("{id}")
            public User getUser(@PathVariable("id") long id) {
        if (id == 0) {
            exceptionService.systemError();
        } else if (id == -1) {
            exceptionService.userError(-1);
        }
//        int a  = 3/0;
        return User.builder().id(id).name("hello").build();
    }
}
