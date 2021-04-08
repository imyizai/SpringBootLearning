package top.yz.boot.mybatis.mapper;

import top.yz.boot.mybatis.domain.Clazz;

public interface ClazzMapper {
    /**
     * 根据班级id查询班级
     *
     * @param clazzId 班级id
     * @return 查询到的班级对象（班级自身信息、班级教师信息、班级所有学生信息）
     */
    Clazz getClazz(int clazzId);

}