package com.lucifer.model;

import lombok.Data;

@Data
public class AwardDayConfig {

    private Integer id;

    private String day;

    private Integer configId;

    private Double rate;

    private  Integer count;
}
