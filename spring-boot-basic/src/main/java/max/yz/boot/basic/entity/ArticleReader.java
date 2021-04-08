package max.yz.boot.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imyizai
 * @ClassName ArticleReader
 * @Description
 * @Date 2021/3/11 7:21 下午
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleReader {
    private String name;
    private Integer age;

}
