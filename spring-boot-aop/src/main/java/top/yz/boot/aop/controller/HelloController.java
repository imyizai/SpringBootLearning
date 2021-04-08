package top.yz.boot.aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yz.boot.aop.annotation.ControllerWebLog;

/**
 * @author imyizai
 * @ClassName HelloController
 * @Description
 * @Date 2021/4/1 2:48 下午
 **/
@RestController
@Slf4j
@RequestMapping(value = "api")
public class HelloController {

    @GetMapping("hello")
    @ControllerWebLog(name="getHello" , isSaved = true)
    public String getHello( String name , String title) {
//        log.info("controller的name参数：" + name);
//        log.info("controller的title参数：" + title);
        //休眠，模拟接口耗时
        try {
            Thread.sleep(6000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return "hello spring boot aop!";
    }
}
