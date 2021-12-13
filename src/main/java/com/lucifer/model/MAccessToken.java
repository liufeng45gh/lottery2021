package com.lucifer.model;

/**
 * Created by Administrator on 2016/6/26.
 */
public class MAccessToken {

    private Long memberId;

    private String token;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
