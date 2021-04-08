package top.yz.boot.servlet.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author imyizai
 * @ClassName TestController
 * @Description
 * @Date 2021/4/6 8:46 上午
 **/
@RestController
@Slf4j
public class TestController {

    @GetMapping("test")
    public String test(HttpServletRequest request, HttpSession session , @RequestParam(name = "name") String name) {
        log.info("进入接口调用");
        log.info("请求参数：" + name);
//        request.setAttribute("a","a");
//        request.getAttribute("a");
//        session.setAttribute("a","aaa");
//        request.removeAttribute("a");
//
//        session.setAttribute("b","b");
//        session.invalidate();
        return "hello springboot!";
    }

    @PostMapping("login")
    public String login(@RequestParam(name = "account") String account , @RequestParam(name = "password") String password) {
        if ("imyizai".equals(account) && "711".equals(password)) {
            return "login success";
        } else {
            return "login failure";
        }
    }
}
