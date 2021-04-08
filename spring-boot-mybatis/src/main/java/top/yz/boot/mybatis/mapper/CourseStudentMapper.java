package top.yz.boot.mybatis.mapper;

import top.yz.boot.mybatis.domain.CourseStudent;

public interface CourseStudentMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CourseStudent record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CourseStudent record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CourseStudent selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CourseStudent record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CourseStudent record);
}