package max.yz.boot.basic.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import max.yz.boot.basic.conf.MixPropertySourceFactory;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


/**
 * @author imyizai
 * @ClassName Family
 * @Description
 * @Date 2021/3/16 1:20 下午
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component//可以被注入
@Validated
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = MixPropertySourceFactory.class)
public class Family {
    @Length(min=5,max=20,message="家庭名长度必须位于5-20之间")
    private  String familyName;
    //    @Resource
    private  Father father;
    //    @Resource
    private  Mother mother;
    //    @Resource
    private  Child  child;


}
