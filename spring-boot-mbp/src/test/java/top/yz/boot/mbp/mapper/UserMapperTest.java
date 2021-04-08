package top.yz.boot.mbp.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yz.boot.mbp.entity.User;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;


    //添加
    @Test
    void  insert() {
        User user = User.builder()
                .name("Mad")
                .age(21)
                .email("md@baomidou.com")
                .build();

        int row = userMapper.insert(user);
        assertEquals(1, row);

        System.out.println("雪花算法id: " + user.getId());
    }


    //删除
    //根据主键id删除
   @Test
    void deleteById() {
        int rows = userMapper.deleteById(1);
       System.out.println("影像记录数：" + rows);
   }

   //根据参数删除数据
   @Test
    void deleteByMap() {
     //构造条件
     Map<String,Object> map = new HashMap<>();
     map.put("name", "Jack");
     map.put("age", 20);
     //执行删除
       int rows = userMapper.deleteByMap(map);
       assertEquals(1,rows);
       System.out.println("影响记录数：" + rows );
   }

   //查询
    //根据主键查询一条数据
    @Test
    void selectById(){
        User user = userMapper.selectById(1376715834772283393L);
        System.out.println(user);
    }

    //根据ids批量查找数据
    @Test
    void selectBatchIds() {
        List<Long> ids = Arrays.asList(
                1376715834772283393L,
                1376715965852561410L,
                1376716206433632258L
        );
        List<User> list = userMapper.selectBatchIds(ids);
        list.forEach(System.out::println);
    }

    //根据指定参数查询
    @Test
    void selectByMap() {
        Map<String, Object> map = new HashMap<>();
        //map的key指代的是mysql表中的列名，并非java实体的属性名
        map.put("name","Jone");

        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }


    //修改
    //通过主键id修改数据
    @Test
    void change() {
        User user = new User();
        user.setId(1376715834772283393L);
        user.setAge(17);
        user.setEmail("rs@outlook.com");
        int rows = userMapper.updateById(user);
        System.out.println("影响记录数：" + rows);
    }

    @Test
    void wrapper() {
        String name="Jack";
        String email="";
//        QueryWrapper<User>query = new QueryWrapper<>();
//        query.like(StringUtils.isNotEmpty(name), "name", name)
//                .like(StringUtils.isNotEmpty(email), "email", email);
//        List<User>list=userMapper.selectList(query);
//        list.forEach(System.out::println);
    }
}