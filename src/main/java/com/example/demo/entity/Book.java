package com.example.demo.entity;
import java.time.LocalDateTime;

public class Book {
   private Long id;
        private String title;
        private String author;
        private String isbn;
        //包装类默认为null，且自带一些方法，写实体类的时候要用包装类，而数据类型默认为0
        private Integer total;
        private Integer available;
        private LocalDateTime createTime;


        public Book() {
        }//无参构造方法，如果不写，会自动加一个

        public Long getId() {
            return id;
        }//读取数据拿数据

        public void setId(Long id) {
            this.id = id;
        }//修改数据加数据

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getAvailable() {
            return available;
        }

        public void setAvailable(Integer available) {
            this.available = available;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        // 重写toString，方便调试打印
        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", isbn='" + isbn + '\'' +
                    ", total=" + total +
                    ", available=" + available +
                    ", createTime=" + createTime +
                    '}';
        }
}
