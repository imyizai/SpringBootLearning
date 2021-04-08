package top.yz.boot.servlet.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author imyizai
 * @ClassName CustomInterceptor
 * @Description
 * @Date 2021/4/6 9:24 上午
 **/
@Component
@Slf4j
public class CustomInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle：请求前调用！");
        log.info(request.getParameter("name"));
        //如果请求参数包含"xx"，返回false，请求中断不走接口；否则返回true，放行到接pr求
        return !request.getParameter("name").contains("xx");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        log.info("postHandle:在请求后、视图渲染完成前调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
//        log.info("afterCompletion:请求调用完成后回调方法，在视图渲染完成后回调");
    }
}
