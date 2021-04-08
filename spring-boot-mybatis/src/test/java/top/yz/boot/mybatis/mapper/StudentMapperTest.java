package top.yz.boot.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.yz.boot.mybatis.domain.Student;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void getStudentManyToOne() {
        Student student = studentMapper.getStudent(1001);
        System.out.println(student);
        assertEquals(1001,student.getStudentId());
        assertEquals("刘毅",student.getStudentName());
        assertEquals(1,student.getClazz().getClazzId());
        assertEquals("软看1921",student.getClazz().getClazzName());
        assertEquals(2,student.getCourses().size());
    }

}