package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewReplay {

    private Integer replayId;
    private Integer reviewId;
    private Integer userId;
    private String content;
    private LocalDateTime createTime;
}