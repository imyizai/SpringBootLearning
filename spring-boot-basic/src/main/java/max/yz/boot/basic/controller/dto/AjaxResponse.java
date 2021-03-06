package max.yz.boot.basic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author imyizai
 * @ClassName AjaxResponse
 * @Description
 * @Date 2021/3/16 1:01 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResponse {
    private  Integer code;
    private  String message;
    private  Object data;

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求成功");
        return ajaxResponse;

    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求成功");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
    public static AjaxResponse failure(String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(500);
        ajaxResponse.setMessage(message);
        return ajaxResponse;
    }

}
