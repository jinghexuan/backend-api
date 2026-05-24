package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowRecord;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowRecordMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowService {

    private final BorrowRecordMapper borrowRecordMapper;
    private final BookMapper bookMapper;

    /** 借阅天数，可按你们规则改 */
    private static final int BORROW_DAYS = 30;

    public BorrowService(BorrowRecordMapper borrowRecordMapper, BookMapper bookMapper) {
        this.borrowRecordMapper = borrowRecordMapper;
        this.bookMapper = bookMapper;
    }

    /**
     * 借书：body 里传 bookId、userId
     */
    @Transactional
    public BorrowRecord borrow(BorrowRecord borrow) {
        if (borrow == null || borrow.getBookId() == null || borrow.getUserId() == null) {
            throw new IllegalArgumentException("bookId 和 userId 不能为空");
        }

        Book book = bookMapper.findById(borrow.getBookId());
        if (book == null) {
            throw new IllegalArgumentException("图书不存在");
        }
        if (book.getAvailable() == null || book.getAvailable() <= 0) {
            throw new IllegalArgumentException("该书暂无可借册数");
        }

        BorrowRecord active = borrowRecordMapper.findActiveBorrow(borrow.getBookId(), borrow.getUserId());
        if (active != null) {
            throw new IllegalArgumentException("您已有该书的未还记录");
        }

        LocalDateTime now = LocalDateTime.now();
        borrow.setBorrowedAt(now);
        borrow.setDueAt(now.plusDays(BORROW_DAYS));
        borrow.setReturnedAt(null);
        borrow.setStatus(1);          // 1=借出中，按你们约定可改
        borrow.setRenewCount(0);

        borrowRecordMapper.insert(borrow);

        book.setAvailable(book.getAvailable() - 1);
        int count = book.getBorrowCount() == null ? 0 : book.getBorrowCount();
        book.setBorrowCount(count + 1);
        bookMapper.update(book);

        return borrow;
    }

    /**
     * 还书：body 里传借阅记录 id
     */
    @Transactional
    public BorrowRecord returnBook(BorrowRecord borrow) {
        if (borrow == null || borrow.getId() == null) {
            throw new IllegalArgumentException("借阅记录 id 不能为空");
        }

        BorrowRecord existing = borrowRecordMapper.findById(borrow.getId());
        if (existing == null) {
            throw new IllegalArgumentException("借阅记录不存在");
        }
        if (existing.getReturnedAt() != null) {
            throw new IllegalArgumentException("该记录已归还");
        }

        existing.setReturnedAt(LocalDateTime.now());
        existing.setStatus(0);        // 0=已还
        borrowRecordMapper.updateReturn(existing);

        Book book = bookMapper.findById(existing.getBookId());
        if (book != null && book.getAvailable() != null) {
            book.setAvailable(book.getAvailable() + 1);
            bookMapper.update(book);
        }

        return existing;
    }

    /** 借阅记录列表（管理端等） */
    public List<BorrowRecord> list() {
        return borrowRecordMapper.findAll();
    }

    /** 按 id 查一条 */
    public BorrowRecord getById(Integer id) {
        if (id == null) {
            return null;
        }
        return borrowRecordMapper.findById(id);
    }
}