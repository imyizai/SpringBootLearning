package top.yz.boot.exception.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imyizai
 * @ClassName User
 * @Description
 * @Date 2021/4/8 2:19 下午
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  long id;
    private  String name;
}
