package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Data
    public class Review {

        private Integer reviewId;
        private Integer bookId;
        private Integer userId;
        private String content;

        /** 对应 decimal(2,1)，用 BigDecimal 更贴切 */
        private BigDecimal rating;

        private LocalDateTime createTime;
        private Integer likeCount;
    }

