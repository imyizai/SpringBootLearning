package top.yz.boot.exception.service;

import org.springframework.stereotype.Service;
import top.yz.boot.exception.commen.CustomExceptionEnum;
import top.yz.boot.exception.exception.CustomException;

/**
 * @author imyizai
 * @ClassName ExceptionService
 * @Description
 * @Date 2021/4/8 2:13 下午
 **/
@Service
public class ExceptionService {
    /**
     * 服务层，模拟系统异常
     */
    public void systemError() {
        try {
            int[] a = new int[]{1, 2, 3};
            System.out.println(a[6]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new CustomException(
                    CustomExceptionEnum.SYSTEM_ERROR,
                    "在XXX业务方法内，出现ArrayIndexOutOfBoundsException，请将该信息告知管理员");
        }
    }

    /**
     * 服务层，模拟用户输入数据导致的校验异常
     *
     * @param input 入参
     */
    public void userError(int input) {
        //模拟业务校验失败逻辑
        if (input < 0) {
            throw new CustomException(
                    CustomExceptionEnum.USER_INPUT_ERROR,
                    "您输入的数据不符合业务逻辑，请确认后重新输入!");
        }
    }
}