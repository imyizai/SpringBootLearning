package top.yz.boot.mbp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"top.yz.boot.mbp.mapper"})
public class SpringBootMbpApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMbpApplication.class, args);
    }

}
