package com.example.demo.controller;
import com.example.demo.common.Result;
import com.example.demo.entity.BorrowRecord;
import com.example.demo.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @PostMapping
    public Result borrow(@RequestBody BorrowRecord borrow) {
        return Result.success(borrowService.borrow(borrow));
    }
    @PutMapping("/return")
    public Result returnbook(@RequestBody BorrowRecord borrow){
        return Result.success(borrowService.returnBook(borrow));
    }
    @GetMapping("/list")
    public Result list(){
        return Result.success(borrowService.list());
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        return Result.success(borrowService.getById(id));
    }
}
