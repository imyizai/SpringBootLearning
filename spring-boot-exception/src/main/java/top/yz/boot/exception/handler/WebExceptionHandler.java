package top.yz.boot.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yz.boot.exception.commen.AjaxResponse;
import top.yz.boot.exception.commen.CustomExceptionEnum;
import top.yz.boot.exception.exception.CustomException;

/**
 * @author imyizai
 * @ClassName WebExceptionHandler
 * @Description
 * @Date 2021/4/8 2:12 下午
 **/
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {
    /**
     * 处理程序员主动转换的自定义异常
     *
     * @param e 自定义异常对象
     * @return 统一响应对象
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException( CustomException
                                           e) {
        if(e.getCode() ==
                CustomExceptionEnum.SYSTEM_ERROR.getCode()){
            //400异常不需要持久化，将异常信息以有好的方式告诉用户就可以
            //将500异常信息持久化处理，方便运维人员处理
            log.error(e.getMessage());
        }
        return AjaxResponse.error(e);
    }

    /**
     * 处理程序员在程序中未能捕获（遗漏的）异常
     *
     * @param e 自定义异常对象
     * @return 统一响应对象
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public  AjaxResponse exception(Exception e) {
        //将异常信息持久化处理，方便运维人员处理
        log.error(e.getMessage());
        return AjaxResponse.error(new CustomException(
                CustomExceptionEnum.OTHER_ERROR));
    }
}
