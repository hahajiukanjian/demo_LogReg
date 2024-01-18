package com.hahajiukanjian.Service;

import com.hahajiukanjian.Pojo.User;

public interface UserService {
    User queryByUsername(String username);
}
