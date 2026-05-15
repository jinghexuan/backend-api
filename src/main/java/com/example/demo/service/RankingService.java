package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 借阅量排行榜 Top10
     */
    public List<Book> borrowTop10() {
        return bookMapper.findBorrowTop10();
    }

    /**
     * 评分排行榜 Top10
     */
    public List<Book> ratingTop10() {
        return bookMapper.findRatingTop10();
    }
}
