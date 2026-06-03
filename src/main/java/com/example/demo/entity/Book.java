package com.example.demo.entity;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private Integer total;
        private Integer available;
        private LocalDateTime createTime;
        private Integer borrowCount;
        private Double rating;
        private String category;
        @JsonProperty("coverUrl")
        private String cover;
        private String publisher;
        private String publishDate;
        private String description;

}
      


      
