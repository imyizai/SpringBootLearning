package top.yz.boot.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author imyizai
 * @ClassName SpringBootServletApplication
 * @Description  启动主类，加上@ServletComponentScan，让servlet组件生效
 * @Date 2021/4/6 8:29 上午
 **/
@SpringBootApplication
@ServletComponentScan
public class SpringBootServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletApplication.class, args);
    }

}
