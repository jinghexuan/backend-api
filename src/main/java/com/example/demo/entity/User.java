package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private Integer personId;
    private Integer userTypeId;
    private String userName;
    private String password;
    private String createTime;
    private Integer creatorId;
    private String lastLoginTime;
    private Integer loginCount;
}
