package top.yz.boot.servlet.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author imyizai
 * ServletContext Listener, HttpSession Listener, ServletRequset Listener
 * @ClassName CustomListener
 * @Description 自定义监听器
 * @Date 2021/4/6 8:33 上午
 **/
@WebListener
@Slf4j
public class CustomListener implements ServletContextListener,
        HttpSessionListener,
        ServletRequestListener,
        ServletRequestAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("应用启动。。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       log.info("应用停止。。。");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session创建。。。");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("session销毁。。。");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("request初始化。。。");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request销毁。。。");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("添加属性。。。");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("移除属性。。。");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("属性值替换。。。");
    }
}
