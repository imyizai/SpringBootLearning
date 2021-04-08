package top.yz.boot.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yz.boot.mybatis.controller.dto.AjaxResponse;
import top.yz.boot.mybatis.domain.Course;
import top.yz.boot.mybatis.mapper.CourseMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2021/3/25
 * @description CourseController
 */
@RestController
@Slf4j
@Validated
@RequestMapping(value = "api/v1/courses")
public class CourseController {
    @Resource
    private CourseMapper courseMapper;

    @GetMapping("all")
    public AjaxResponse selectAll(){
        List<Course> courses = courseMapper.selectAll();
    return AjaxResponse.success(courses);
    }
}