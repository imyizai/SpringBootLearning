package top.yz.boot.exception.exception;

import top.yz.boot.exception.commen.CustomExceptionEnum;

/**
 * @author imyizai
 * @ClassName CustomException
 * @Description
 * @Date 2021/4/8 2:10 下午
 **/
public class CustomException extends  RuntimeException {
    /**
     * 异常错误编码
     */
    private int code;
    /**
     * 异常信息
     */
    private String message;
    private  CustomException() {
    }

    public CustomException(CustomExceptionEnum
                           exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }

    public CustomException(CustomExceptionEnum
                           exceptionEnum,
                              String message) {
        this.code = exceptionEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
