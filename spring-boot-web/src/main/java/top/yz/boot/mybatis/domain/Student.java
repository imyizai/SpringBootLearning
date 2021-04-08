package top.yz.boot.mybatis.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
    * 学生id
    */
    private Integer studentId;

    /**
    * 学生所属班级的id
    */
    private Integer clazzId;

    /**
    * 学生姓名
    */
    private String studentName;

    /**
    * 学生籍贯
    */
    private String hometown;

    /**
    * 出生日期
    */
    private Date birthday;
}