package com.hahajiukanjian.Controller;

import com.hahajiukanjian.Pojo.User;
import com.hahajiukanjian.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // 处理登录逻辑
//        System.out.println("123123");
        if (username == null || password == null) {
            model.addAttribute("errorMessage", "账号或密码不能为空");
            return "/index";
        }

        User user = userService.queryByUsername(username);
        if (user == null) {
            model.addAttribute("errorMessage", "您尚未注册");
            return "index";
        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            model.addAttribute("successMessage", username);
            return "success";
        } else {
            model.addAttribute("errorMessage", "登录失败，账号或密码错误");
            return "index";
        }
    }

    @RequestMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        // 处理注册逻辑
        if (username == null || password == null) {
            return "index";
        }

        User user = new User();
        user.setUsername(username); user.setPassword(password);
        userService.insertUser(user);

        return "index";
    }
}
