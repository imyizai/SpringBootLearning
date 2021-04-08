package top.yz.boot.mybatis.mapper;

import top.yz.boot.mybatis.domain.Student;

public interface StudentMapper {
    /**
     * 根据学生id查询 （关联查询出所属班级信息）
     *
     * @param studentId 学生id
     * @return student对象
     */

    Student getStudent(int studentId);

}