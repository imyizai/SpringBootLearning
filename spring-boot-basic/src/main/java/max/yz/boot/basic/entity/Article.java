package max.yz.boot.basic.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author imyizai
 * @ClassName Article
 * @Description： 文章
 * @Date 2021/3/11 7:28 下午
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder(value = {"content","title"})
public class Article {
//    @JsonIgnore
    private  Integer id;

//    @JsonProperty("name")
    private  String author;

    private  String title;
    private  String content;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    //以后要用的时候 放出来
//    private List<ArticleReader> readers;


}
