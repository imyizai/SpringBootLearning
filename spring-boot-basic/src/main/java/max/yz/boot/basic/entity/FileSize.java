package max.yz.boot.basic.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author imyizai
 * @ClassName FileSize
 * @Description
 * @Date 2021/3/16 1:26 下午
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FileSize {
    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSize;
}
