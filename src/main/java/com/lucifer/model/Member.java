package com.lucifer.model;

import lombok.Data;

import java.util.Date;

@Data
public class Member {

    private Long id;

    private String wxId;

    private String phone;

    private String nickName;

    private String avatar;

    private String realName;

    private Date createdAt;

    private Date updatedAt;

    private String status;

}
