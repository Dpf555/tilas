package com.dupf.mapper;

import com.dupf.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
//    方法一：手动映射
//    @Results({
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })

//     方法二：起别名
//    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc;")

    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();

    // 根据ID删除部门
    @Delete("delete from dept where id=#{id};")
    void deleteById(Integer id);
}
