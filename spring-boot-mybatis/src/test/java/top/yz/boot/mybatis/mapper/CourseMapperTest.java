package top.yz.boot.mybatis.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.yz.boot.mybatis.domain.Course;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class CourseMapperTest {
    @Resource
    private  CourseMapper courseMapper;

    @Test
    void selectAll() {
        List<Course> courses = courseMapper.selectAll();
        System.out.println(courses);
        assertEquals(2,courses.size());
    }

}