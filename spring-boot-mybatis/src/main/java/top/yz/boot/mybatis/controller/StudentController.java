package top.yz.boot.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yz.boot.mybatis.controller.dto.AjaxResponse;
import top.yz.boot.mybatis.mapper.StudentMapper;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2021/3/25
 * @description StudentController
 */
@RestController
@RequestMapping(value = "api/v1/students")
@Slf4j
@Validated
public class StudentController {
    @Resource
    private StudentMapper studentMapper;

    @GetMapping("{studentId}")
    public AjaxResponse getStudent(@PathVariable("studentId") int studentId) {
        return  AjaxResponse.success(studentMapper.getStudent(studentId));
    }
}