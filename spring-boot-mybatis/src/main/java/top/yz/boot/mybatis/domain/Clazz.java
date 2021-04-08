package top.yz.boot.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Clazz {
    /**
    * 班级id
    */
    private Integer clazzId;

    /**
    * 班级姓名
    */
    private String clazzName;

    /**
    * 班级管理老师的id
    */
    private Integer teacherId;

    /**
     * 管理班级的教师对象（一对一）
     */
    private  Teacher teacher;

    /**
     * 一方里声明多方的集合 (一对多)
     */
    private List<Student> students;
}