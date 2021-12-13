package com.lucifer.model;

import lombok.Data;

import java.util.Date;

@Data
public class Wish {

    Long id;

    Long memberId;

    String nickName;

    String text;

    Integer isShow;

    Date createdAt;
}
