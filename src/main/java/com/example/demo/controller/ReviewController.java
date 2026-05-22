package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Review;
import com.example.demo.entity.ReviewReplay;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /** 新增书评 POST /api/review */
    @PostMapping
    public Result add(@RequestBody Review review) {
        return Result.success(reviewService.add(review));
    }

    /** 修改书评 PUT /api/review */
    @PutMapping
    public Result update(@RequestBody Review review) {
        return Result.success(reviewService.update(review));
    }

    /** 删除书评 DELETE /api/review/{id} */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean ok = reviewService.delete(id);
        return ok ? Result.success() : Result.error("书评不存在或删除失败");
    }

    /** 某本书的书评列表 GET /api/review/book/{bookId} */
    @GetMapping("/book/{bookId}")
    public Result listByBookId(@PathVariable Integer bookId) {
        return Result.success(reviewService.listByBookId(bookId));
    }

    /** 点赞 POST /api/review/{id}/like?userId=1 */
    @PostMapping("/{id}/like")
    public Result like(@PathVariable Integer id, @RequestParam Integer userId) {
        return Result.success(reviewService.like(id, userId));
    }

    /** 回复书评 POST /api/review/{id}/reply */
    @PostMapping("/{id}/reply")
    public Result reply(@PathVariable Integer id, @RequestBody ReviewReplay replay) {
        return Result.success(reviewService.reply(id, replay));
    }
}