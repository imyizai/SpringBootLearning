package top.yz.boot.mybatis.mapper;

import top.yz.boot.mybatis.domain.Teacher;

public interface TeacherMapper {
    /**
     * 根据教师id查询教师信息（一对一，关联查询出其管理的班级对象信息）
     *
     * @param teacherId 教师id
     * @return teacher对象
     */
   Teacher getTeacherOneByOne(int teacherId);
}