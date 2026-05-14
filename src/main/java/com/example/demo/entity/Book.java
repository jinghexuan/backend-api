package com.example.demo.entity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.ToString;
@Data
public class Book {
        private Long id;
        private String title;
        private String author;
        private String isbn;
        //包装类默认为null，且自带一些方法，写实体类的时候要用包装类，而数据类型默认为0
        private Integer total;
        private Integer available;
        private LocalDateTime createTime;
}
      


      
