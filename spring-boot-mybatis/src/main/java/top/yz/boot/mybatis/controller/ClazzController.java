package top.yz.boot.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yz.boot.mybatis.controller.dto.AjaxResponse;
import top.yz.boot.mybatis.mapper.ClazzMapper;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2021/3/25
 * @description ClazzController
 */
@RestController
@RequestMapping(value = "api/v1/clazz")
@Slf4j
@Validated
public class ClazzController {
    @Resource
    private ClazzMapper clazzMapper;

    @GetMapping("{clazzId}")
    public AjaxResponse getClazz(@PathVariable("clazzId") int  clazzId) {
        return  AjaxResponse.success(clazzMapper.getClazz(clazzId));
    }
}