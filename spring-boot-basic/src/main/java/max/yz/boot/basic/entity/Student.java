package max.yz.boot.basic.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author imyizai
 * @ClassName Student
 * @Description
 * @Date 2021/3/16 1:25 下午
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;

}

