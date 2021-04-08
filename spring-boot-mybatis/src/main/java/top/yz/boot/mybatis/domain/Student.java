package top.yz.boot.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private LocalDate birthday;

    /**
     * 在多方里，声明一方的对象
     */
    private Clazz clazz;

    /**
     * 学生和课程多对多
     */
    private List<Course> courses;
}