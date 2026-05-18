package com.example.demo.mapper;

import com.example.demo.entity.BorrowRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface BorrowRecordMapper {
    @Select("SELECT COUNT(*) FROM borrowRecord")
    int countBorrowRecords();
    @Select("SELECT *FROM borrow_record ORDER BY borrow_time DESC LIMIT 10")
    List<BorrowRecord> findRecentBorrows();
@Select("SELECT COUNT(*) FROM borrow_record")
    int countTotalBorrows();
@Select("SELECT COUNT(*) FROM borrow_records WHERE returnedAt IS NOT NULL ")
    int countReturnedBooks();
@Select("SELECT COUNT(*) FROM borrow_record WHERE MONTH(borrowAt)=MONTH(CURDATE()) AND YEAR(borrowAt)=YEAR(CURDATE()) ")
    int countThisMonthBorrows();
@Select("SELECT DATE_FORMAT(borrowedAt,'%Y-%m') AS borrowCount FROM borrow_count GROUP BY month ORDER BY month ASC")
    List<Map<String,Object>> findBorrowTrends();
}
