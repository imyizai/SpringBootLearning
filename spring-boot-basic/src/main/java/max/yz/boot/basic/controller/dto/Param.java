package max.yz.boot.basic.controller.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author imyizai
 * @ClassName Param
 * @Description
 * @Date 2021/3/16 1:01 下午
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Param {
    private Integer id;
    private  String title;
}
