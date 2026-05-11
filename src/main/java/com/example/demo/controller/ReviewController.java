package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Review;
import com.example.demo.service.ReviewService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public Result add(@RequestBody Review review){
        return Result.success(reviewService.add);
    }
    @PutMapping
    public Result update(@RequestBody Review review){
        return Result.success(reviewService.update);
    }
    @Delete("/{id}")
    public Result delete(@PathVariable Review review){
        return Result.success(reviewService.delete);
    }
    @GetMapping("/book/{bookId}")
    public Result listByBookId(@PathVariable Integer bookId){
        return Result.success(reviewService.listByBookId(bookId));
    }
    @PostMapping("/{id}/like")
    public Result like(@PathVariable Integer id){
        return Result.success(reviewService.like(id));
    }
    @PostMapping("/{id}/reply")
    public Result reply(@PathVariable Integer id, @RequestBody Review reply) {
        return Result.success(reviewService.reply(id, reply));
    }
}
