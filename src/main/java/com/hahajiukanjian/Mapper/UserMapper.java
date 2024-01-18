package com.hahajiukanjian.Mapper;

import com.hahajiukanjian.Pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User queryByUsername(@Param("username") String username);
}
