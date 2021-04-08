package max.yz.boot.basic.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author imyizai
 * @ClassName Mother
 * @Description
 * @Date 2021/3/16 1:25 下午
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "family.mother")
public class Mother {
    private  String name;
    private List<String> alias;

}