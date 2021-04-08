package top.yz.boot.aop.annotation;

import java.lang.annotation.*;

/**
 * @decription: 自定义Web日志注解
 * @author imyizai
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 调用的接口方法名称
     * @return  String
     */
    String name();

    /**
     * 日志是否要持久化存储
     *
     * @return boolean
     */

    boolean isSaved() default false;

}
