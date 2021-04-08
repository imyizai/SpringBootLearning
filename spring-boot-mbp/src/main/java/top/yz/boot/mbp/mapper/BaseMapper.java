package top.yz.boot.mbp.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> extends Mapper<T> {


    int delete(@Param("ew")Wrapper<T> wrapper);

    int update(@Param("et") T entity, @Param("ew")
            Wrapper<T> updateWrapper);

    T selectOne (@Param("ew") Wrapper<T> queryWrapper);

    Integer selectCount(@Param("ew") Wrapper<T>
                        queryWrapper);

    List<T> selectList(@Param("ew") Wrapper<T>
    queryWrapper);

    List<Map<String,Object>> selectMaps(@Param("ew")
                                        Wrapper<T> queryWrapper);

    List<Object> selectObjs(@Param("ew") Wrapper<T>
                            queryWrapper);

    IPage<T> selectPage(IPage<T> page, @Param("ew")
            Wrapper<T>queryWrapper);

    IPage<Map<String, Object>>selectMapsPage(IPage<T>page,
                                             @Param("ew") Wrapper<T>queryWrapper);


}
