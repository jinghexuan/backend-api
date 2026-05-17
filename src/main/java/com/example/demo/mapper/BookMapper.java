package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book")
    List<Book> findALL();

    @Select("SELECT * FROM book ORDER BY borrow_count DESC LIMIT 10")
    List<Book> findBorrowTop10();

    @Select("SELECT * FROM book ORDER BY rating DESC LIMIT 10")
    List<Book> findRatingTop10();
    @Select("SELECT COUNT(*) FROM book")
    int countBooks();
    @Select("SELECT *FROM book ORDER BY borrow_count DESC LIMIT 10")
    List<Book> getHotBooks();
    @Select("SELECT category, COUNT(*) AS count FROM book GROUP BY category ORDER BY count DESC")
    List<Map<String, Object>> findCategoryStats();

}


