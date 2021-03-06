package max.yz.boot.basic.entity;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.Min;


/**
 * @author imyizai
 * @ClassName Father
 * @Description
 * @Date 2021/3/16 1:25 下午
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Father {
    @NotEmpty
//    @Value("${family.father.name}")
    private  String name;
    @Min(21)
//    @Value("${family.father.age}")
    private Integer age;
}
