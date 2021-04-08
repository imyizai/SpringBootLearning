package top.yz.boot.mybatis.mapper;

import top.yz.boot.mybatis.domain.Course;

import java.util.List;

public interface CourseMapper {
    /**
     * 查询所有课程（同时关联查询出每门课程的选课学生
     * @
     * @return List<Course>
     */
    List<Course> selectAll();

}