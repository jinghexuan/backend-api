package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.math.BigDecimal;

@Mapper
public interface ReviewMapper {
    @Select("SELECT COUNT(*) FROM review")
    int countReview();

    @Select("SELECT AVG(rating) FROM review WHERE book_id = #{bookId}")
    BigDecimal avgRatingByBookId(Integer bookId);
}
