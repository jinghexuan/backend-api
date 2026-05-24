package com.example.demo.mapper;

import com.example.demo.entity.ReviewLike;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewLikeMapper {

    @Insert("INSERT INTO review_like(review_id, user_id, create_time) " +
            "VALUES(#{reviewId}, #{userId}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "likeId")
    int insert(ReviewLike like);

    /** 是否已点赞（防重复点赞） */
    @Select("SELECT * FROM review_like WHERE review_id = #{reviewId} AND user_id = #{userId} LIMIT 1")
    ReviewLike findByReviewAndUser(@Param("reviewId") Integer reviewId, @Param("userId") Integer userId);

    /** 某条书评的点赞列表（可选） */
    @Select("SELECT * FROM review_like WHERE review_id = #{reviewId} ORDER BY create_time DESC")
    List<ReviewLike> findByReviewId(Integer reviewId);

    /** 某条书评被赞次数 */
    @Select("SELECT COUNT(*) FROM review_like WHERE review_id = #{reviewId}")
    int countByReviewId(Integer reviewId);

    /** 取消点赞 */
    @Delete("DELETE FROM review_like WHERE review_id = #{reviewId} AND user_id = #{userId}")
    int deleteByReviewAndUser(@Param("reviewId") Integer reviewId, @Param("userId") Integer userId);

    @Delete("DELETE FROM review_like WHERE like_id = #{likeId}")
    int deleteById(Integer likeId);
}