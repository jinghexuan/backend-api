package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
public class User {
    private Integer personId;
    private Integer userTypeId;
    private String userName;
    @ToString.Exclude  
    private String password;
    private String createTime;
    private Integer creatorId;
    private String lastLoginTime;
    private Integer loginCount;
}
