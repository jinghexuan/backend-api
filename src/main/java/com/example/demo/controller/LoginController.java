package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> params) {
        String userName = params.get("userName");
        String password = params.get("password");

        Map<String, Object> result = new HashMap<>();

        User user = userService.login(userName, password);

        if (user != null) {
            result.put("code", 200);
            result.put("msg", "登录成功");
            Map<String, Object> data = new HashMap<>();
            data.put("userName", user.getUserName());
            data.put("personId", user.getPersonId());
            result.put("data", data);
        } else {
            result.put("code", 401);
            result.put("msg", "用户名或密码错误");
        }

        return result;
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return Result.success(userService.register(user));
    }
    @PostMapping("/logout")
    public Result logout(@RequestBody Map<String,String>params){
        String userId= params.get("userId");
        return Result.success(userService.logout(userId));
    }
}
