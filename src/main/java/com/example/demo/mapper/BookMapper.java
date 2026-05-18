package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("SELECT * FROM book")
    List<Book> findALL();

    @Select("SELECT id,title, author, isbn, total, available, create_time, rating FROM book WHERE id = #{id}")
    Book findById(Integer id);

    @Select("SELECT * FROM book ORDER BY borrow_count DESC LIMIT 10")
    List<Book> findBorrowTop10();

    @Select("SELECT * FROM book ORDER BY rating DESC LIMIT 10")
    List<Book> findRatingTop10();

    @Insert("INSERT INTO book(title, author, isbn, total, available, create_time,rating) " +
            "VALUES(#{name}, #{author}, #{isbn}, #{price}, #{stock}, #{borrowCount}, #{rating})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Book book);

    @Update("UPDATE book SET name=#{name}, author=#{author}, isbn=#{isbn}, price=#{price}, " +
            "stock=#{stock}, borrow_count=#{borrowCount}, rating=#{rating} WHERE id=#{id}")
    int update(Book book);

    @Delete("DELETE FROM book WHERE id = #{id}")
    int deleteById(Integer id);
}


