package top.yz.boot.servlet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yz.boot.servlet.interceptor.CustomInterceptor;

import javax.annotation.Resource;

/**
 * @author imyizai
 * @ClassName MyWebMvcConfig
 * @Configuration 注解标本类为一个配置类，SpringBoot会自动配置
 * @Description 自定义拦截器注册类
 * @Date 2021/4/6 9:31 上午
 **/
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    /**
     * 注入自定义拦截器
     */
    @Resource
    CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，排除路径
        registry.addInterceptor(customInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
