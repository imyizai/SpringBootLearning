package top.yz.boot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.yz.boot.aop.annotation.ControllerWebLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author imyizai
 * @ClassName ControllerWebLogAspect
 * @Description 自定义切面,注意头部注解的作用
 * @Date 2021/4/1 2:31 下午
 **/

@Aspect
@Component
@Slf4j
@Order(1)
public class ControllerWebLogAspect {
    /**
     * ThreadLocal可以让我们拥有当前线程的变量
     * 保存数据，可以实现线程隔离
     * 用于在各个方面之间共享日志数据
     */
    private ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * top.yz.boot.aop.controller..*.*(..))")
    public void webLog() {

    }
    /**
     * 配置增强
     *
     * @param joinPoint 切点
     * @param controllerWebLog 自定义日志注解对象
     */

    @Before(value = "webLog() && @annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog){
        System.out.println(joinPoint);
        System.out.println(controllerWebLog);
        //从请求上下文中取得request的属性集合
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        //向下转型
        ServletRequestAttributes sra =  (ServletRequestAttributes) ra;
        //取得request的对象
        assert sra != null;
        HttpServletRequest request =  sra.getRequest();
        log.info("请求的URL：" + request.getRequestURI());
        log.info("请求的方法：" + request.getMethod());
        log.info("请求的地址：" + request.getRemoteAddr());
        log.info("请求的User-Agent：" + request.getHeader("User-Agent"));
        //自定义注解中需要保存日志
        if(controllerWebLog.isSaved()){
            //取得接口请求参数
            Object[] args = joinPoint.getArgs();
            log.info("参数数组：" + Arrays.toString(args));
            Map<String,Object> map = new HashMap<>();
            map.put("uri",request.getRequestURI());
            map.put("title",args[1]);
            map.put("name",args[0]);
            threadLocal.set(map);
            log.info("日志数据已保存。。。");
//            try{
//                Thread.sleep(3000);
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Map<String , Object> result = threadLocal.get();
//            log.info("保存的日志数据是：" + result);
        }else {
            log.info("访问成功，日志不需要保存");
        }

    }

    @AfterReturning(value = "webLog() && @annotation(controllerWebLog)" , returning = "res")
    public void doAfterReturning(ControllerWebLog controllerWebLog, Object res){
      Map<String,Object> result = threadLocal.get();
      log.info("日志数据是：" + result);
    }

    /**
     * 通过环绕增强获取目标方法执行时间，可用于分析性能
     * 可通过连接点入参和反射机制， 在这里调用目标方法getHello(),并返回调用结果
     *
     * @param proceedingJoinPoint 切点
     * @return Object
     * @throws Throwable
     */
    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //得到开始时间
        long startTime = System.currentTimeMillis();
        //执行连接点的目标方法getHello()
        Object ob = proceedingJoinPoint.proceed();
//        Map<String,Object> threadInfo = threadLocal.get();
        System.out.println(ob);
        //计算出方法的真实执行时间，可以在目标方法中加入线程休眠体会结束
        Long takeTime = System.currentTimeMillis() - startTime;
        //存入线程变量
//        threadInfo.put("takeTime" ,takeTime);
        log.info("耗时:" + takeTime);
//        threadLocal.set(threadInfo);
        return ob;
    }

    /**
     * 异常处理
     *
     * @param throwable 异常
     */
    @AfterThrowing(value = "webLog()", throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //异常信息
        log.error("{}接口调用异常，异常信息{}",request.getRequestURI(),throwable.getMessage());
    }
}
