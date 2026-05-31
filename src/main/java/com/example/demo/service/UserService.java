package com.example.demo.service;

import com.example.demo.entity.BorrowRecord;
import com.example.demo.entity.Review;
import com.example.demo.entity.User;
import com.example.demo.mapper.BorrowRecordMapper;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    public User login(String userName, String password) {
        return userMapper.login(userName, password);
    }
    public int register(User user){
        return userMapper.register(user.getUserName(), user.getPassword());
    }
    public String logout(String userId){
        return "退出成功,用户ID："+userId;
    }

    public List<BorrowRecord> getBorrowList(Integer userId) {
        return borrowRecordMapper.findByUserId(userId);
    }

    public List<Review> getMyReviews(Integer userId) {
        return reviewMapper.findByUserId(userId);
    }

    public int updateInfo(User user) {
        return userMapper.updateInfo(user.getUserName(), user.getPersonId());
    }
}
