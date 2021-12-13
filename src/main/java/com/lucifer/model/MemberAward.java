package com.lucifer.model;

import lombok.Data;

import java.util.Date;

@Data
public class MemberAward {

    private Integer id;

    private Long memberId;

    private Integer awardId;


    private Date created_at;

    private Integer count;

    private String name;


}
