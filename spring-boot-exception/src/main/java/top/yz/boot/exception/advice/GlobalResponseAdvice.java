package top.yz.boot.exception.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.yz.boot.exception.commen.AjaxResponse;

/**
 * @author imyizai
 * @ClassName GlobalResponseAdvice
 * @Description
 * @Date 2021/4/8 2:16 下午
 **/



@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter
                                          methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest
                                          serverHttpRequest,
                                  ServerHttpResponse
                                          serverHttpResponse) {
        //如果响应结果是JSON数据类型
        if (mediaType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)) {
            if (body instanceof AjaxResponse) {
                AjaxResponse ajaxResponse = (AjaxResponse) body;
                //999 不是标准的HTTP状态码，特殊处理
                if(ajaxResponse.getCode() != 999){
                serverHttpResponse.setStatusCode(HttpStatus.valueOf(
                        ajaxResponse.getCode()
                ));
            }
            return body;
        } else {
            serverHttpResponse.setStatusCode(HttpStatus.OK);
            return AjaxResponse.success(body);
        }
    }
    return body;
}
}


