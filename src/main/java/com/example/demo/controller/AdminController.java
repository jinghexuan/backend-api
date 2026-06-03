package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Book;
import com.example.demo.service.AdminService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Result listBooks() {
        return Result.success(bookService.list());
    }

    @GetMapping("/books/{id}")
    public Result getBookById(@PathVariable Integer id) {
        return Result.success(bookService.getById(id));
    }

    @PostMapping("/books")
    public Result addBook(@RequestBody Book book) {
        return Result.success(bookService.add(book));
    }

    @PutMapping("/books")
    public Result updateBook(@RequestBody Book book) {
        return Result.success(bookService.update(book));
    }

    @DeleteMapping("/books/{id}")
    public Result deleteBook(@PathVariable Integer id) {
        return Result.success(bookService.delete(id));
    }

    /**
     * 封面上传
     * POST /api/admin/upload/cover
     */
    @PostMapping("/upload/cover")
    public Result uploadCover(@RequestParam("file") MultipartFile file) {
        System.out.println("[UPLOAD] 收到上传请求, 文件名=" + file.getOriginalFilename() + " 大小=" + file.getSize());
        if (file.isEmpty()) {
            return Result.error("文件为空");
        }

        try {
            // 上传目录：项目根目录下的 uploads/
            String uploadDir = System.getProperty("user.dir") + File.separator + "uploads";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 生成唯一文件名
            String originalName = file.getOriginalFilename();
            String suffix = "";
            if (originalName != null && originalName.contains(".")) {
                suffix = originalName.substring(originalName.lastIndexOf("."));
            }
            String newFileName = UUID.randomUUID().toString() + suffix;

            // 保存文件
            Path filePath = Paths.get(uploadDir, newFileName);
            Files.write(filePath, file.getBytes());

            // 返回可访问的 URL
            String url = "http://localhost:8081/uploads/" + newFileName;
            System.out.println("[UPLOAD] 上传成功: " + url);
            return Result.success(url);

        } catch (Exception e) {
            System.err.println("[UPLOAD ERROR] 上传异常: " + e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            return Result.error("上传失败: " + e.getMessage());
        }
    }
}

