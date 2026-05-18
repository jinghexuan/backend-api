package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewLike {

    private Integer likeId;
    private Integer reviewId;
    private Integer userId;
    private LocalDateTime createTime;
}