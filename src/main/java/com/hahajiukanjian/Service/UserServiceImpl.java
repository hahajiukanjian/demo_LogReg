package com.hahajiukanjian.Service;

import com.hahajiukanjian.Mapper.UserMapper;
import com.hahajiukanjian.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }
}
