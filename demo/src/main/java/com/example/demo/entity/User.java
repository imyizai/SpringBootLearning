package com.example.demo.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

/**
 * @author imyizai
 * @ClassName User
 * @Description
 * @Date 2021/3/18 2:27 下午
 **/
@Data
@EntityScan //声明实体类，与数据库中的表对应
@Table(name = "t_user")//生成数据表
public class User {

    @Id  // 表明id
    @GeneratedValue( strategy = GenerationType.IDENTITY) //自动生成、递增
    private Long id;
    private String name;
}
