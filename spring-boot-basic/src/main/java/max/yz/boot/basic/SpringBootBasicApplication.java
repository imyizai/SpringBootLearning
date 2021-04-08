package max.yz.boot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations = "classpath:beans.xml")
@ImportAutoConfiguration
public class SpringBootBasicApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootBasicApplication.class, args);
    }

}
