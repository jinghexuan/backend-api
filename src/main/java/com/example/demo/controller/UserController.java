package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/borrows")
    public Result getBorrowList(){
        return Result.success(userService.getBorrowList());
    }
    @GetMapping("/reviews")
    public Result getMyReviews(){
        return Result.success(userService.getMyReviews());
    }
    @PutMapping("/info")
    public Result updateInfo(@RequestBody User user){
        return Result.success(userService.updateInfo());
    }
}
