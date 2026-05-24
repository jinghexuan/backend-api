package com.example.demo.mapper;

import com.example.demo.entity.ReviewReplay;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReviewReplayMapper {

    @Insert("INSERT INTO review_replay(review_id, user_id, content, create_time) " +
            "VALUES(#{reviewId}, #{userId}, #{content}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "replayId")
    int insert(ReviewReplay replay);

    @Select("SELECT * FROM review_replay WHERE replay_id = #{replayId}")
    ReviewReplay findById(Integer replayId);

    /** 某条书评下的所有回复 */
    @Select("SELECT * FROM review_replay WHERE review_id = #{reviewId} ORDER BY create_time ASC")
    List<ReviewReplay> findByReviewId(Integer reviewId);

    @Update("UPDATE review_replay SET content = #{content} WHERE replay_id = #{replayId}")
    int update(ReviewReplay replay);

    @Delete("DELETE FROM review_replay WHERE replay_id = #{replayId}")
    int deleteById(Integer replayId);

    @Select("SELECT COUNT(*) FROM review_replay WHERE review_id = #{reviewId}")
    int countByReviewId(Integer reviewId);
}