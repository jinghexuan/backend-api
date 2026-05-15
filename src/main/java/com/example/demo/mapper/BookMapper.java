package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book")
    List<Book> findALL();

    @Select("SELECT * FROM book ORDER BY borrow_count DESC LIMIT 10")
    List<Book> findBorrowTop10();

    @Select("SELECT * FROM book ORDER BY rating DESC LIMIT 10")
    List<Book> findRatingTop10();
}


