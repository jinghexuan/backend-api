
  package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowRecord {

   
    private Integer id;

    private Integer bookId;
    private Integer userId;

    private LocalDateTime borrowedAt;

  
    private LocalDateTime dueAt;

    private LocalDateTime returnedAt;

    private Integer status;

    private Integer renewCount;

    private LocalDateTime lastRenewedAt;

}
