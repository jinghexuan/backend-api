package com.example.demo.entity;

import lombok.Data;

@Data
public class Book {
    private Integer bookId;         // 图书ID
    private String bookName;        // 书名
    private String author;          // 作者
    private String isbn;            // ISBN号
    private String publisher;       // 出版社
    private Integer categoryId;     // 分类ID
    private String categoryName;    // 分类名
    private Integer borrowCount;    // 借阅次数
    private Double rating;          // 评分
    private Integer stock;          // 库存
    private String coverImage;      // 封面图片
    private String description;     // 简介
}
