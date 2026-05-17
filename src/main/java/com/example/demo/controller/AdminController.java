package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/dashboard/stats")
    public Result getDashboard(){
        return Result.success(adminService.getDashboard());
    }
    @GetMapping("/dashboard/recent")
    public Result getRecentBorrows(){
        return Result.success(adminService.getRecentBorrows());
    }
    @GetMapping("/dashboard/hot-books")
    public Result getHotBooks(){
        return Result.success(adminService.getHotBooks());
    }
    @GetMapping("/dashboards/active-users")
    public Result getActiveUsers(){
        return Result.success(adminService.getActiveUsers());
    }
    @GetMapping("/users")
    public Result listUsers(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int pageSize){
        return Result.success(adminService.listUsers(page,pageSize));
    }
    @GetMapping("/user/stats")
    public Result getUserStats(){
        return Result.success(adminService.getUserStats());
    }
    @PutMapping("/user/{id}/status")
    public Result toggleUserStatus(@PathVariable Long id,
                                   @RequestParam int status) {
        return Result.success(adminService.toggleUserStatus(id, status));
    }

    @GetMapping("/borrows/stats")
    public Result getBorrowStats(){
        return Result.success(adminService.getBorrowStats());
    }
    @GetMapping("/borrow/trend")
    public Result getBorrowTrend(){
        return Result.success(adminService.getBorrowTrend());
    }
    @GetMapping("/borrow/category")
    public Result getCategoryStats(){
        return Result.success(adminService.getCategoryStats());
    }
}
