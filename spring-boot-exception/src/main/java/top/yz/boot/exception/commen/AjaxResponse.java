package top.yz.boot.exception.commen;

import lombok.Data;
import top.yz.boot.exception.exception.CustomException;

/**
 * @author imyizai
 * @ClassName AjaxResponse
 * @Description
 * @Date 2021/4/8 2:20 下午
 **/
@Data
public class AjaxResponse {
    /**
     * 请求响应状态码
     */
    private int code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据（通常用于查询操作）
     */
    private Object data;

    private AjaxResponse() {

    }

    /**
     * 请求出现异常时的响应数据封装
     *
     * @param e 自定义异常对象
     * @return AjaxResponse
     */
    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }

    /**
     * 请求出现异常时的响应数据封装
     *
     * @param customExceptionEnum 异常类型枚举
     * @param errorMessage        异常信息
     * @return AjaxResponse
     */
    public static AjaxResponse error(CustomExceptionEnum customExceptionEnum, String errorMessage) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setCode(customExceptionEnum.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    /**
     * 请求成功的响应，不带查询数据（用于删除、修改、新增接口）
     *
     * @return AjaxResponse
     */
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带查询数据（用于查询接口）
     *
     * @return AjaxResponse
     */
    public static AjaxResponse success(Object data) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(data);
        return ajaxResponse;
    }
}
