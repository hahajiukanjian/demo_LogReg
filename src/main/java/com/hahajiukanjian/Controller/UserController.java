package com.hahajiukanjian.Controller;

import com.hahajiukanjian.Pojo.User;
import com.hahajiukanjian.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // 处理登录逻辑
//        System.out.println("123123");
        if (username == null || password == null) {
            return "redirect:/";
        }

        User user = userService.queryByUsername(username);
        if (user == null) {
            return "redirect:/failed.html";
        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return "redirect:/success.html"; // 重定向到首页或其他页面
        } else {
            return "redirect:/failed.html";
        }
    }

    @RequestMapping("/register")
    public String register() {
        // 处理注册逻辑
        return "redirect:/failed.html"; // 重定向到首页或其他页面
    }
}
