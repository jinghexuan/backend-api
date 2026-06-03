package com.example.demo.service;


import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowRecordMapper;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BorrowRecordMapper borrowRecordMapper;
    @Autowired
    private UserMapper userMapper;
    public Map<String,Object> getStats(){
        Map<String,Object> data=new HashMap<>();
        data.put("bookCount",bookMapper.countBooks());
        data.put("borrowCount",borrowRecordMapper.countTotalBorrows());
        data.put("countUsers",userMapper.countUsers());
        return data;
    }
    public List<com.example.demo.entity.Book> getHotBooks(){
        return bookMapper.getHotBooks();
    }
}
