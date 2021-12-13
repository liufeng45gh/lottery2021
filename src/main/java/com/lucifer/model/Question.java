package com.lucifer.model;

import java.util.Date;
import java.util.List;

public class Question {

    private Long id;

    private String title;

    private String status;

    private String rightAnswer;

    private String rightAnswerDescription;

    private Integer isMoreSelect;

    private Date createdAt;

    private Date updatedAt;

    private List<Answer> answerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getRightAnswerDescription() {
        return rightAnswerDescription;
    }

    public void setRightAnswerDescription(String rightAnswerDescription) {
        this.rightAnswerDescription = rightAnswerDescription;
    }

    public Integer getIsMoreSelect() {
        return isMoreSelect;
    }

    public void setIsMoreSelect(Integer isMoreSelect) {
        this.isMoreSelect = isMoreSelect;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
