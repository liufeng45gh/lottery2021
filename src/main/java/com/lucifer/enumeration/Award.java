package com.lucifer.enumeration;

import lombok.Data;


public enum Award {

    King(1,"王者粉丝奖 100元加油卡",0,0.001d),
    diamond(2,"钻石粉丝奖 30元红包",0,0.003d),
    platinum(3,"白金粉丝奖 20元红包",0,0.005d),
    gold(4,"黄金粉丝奖 10元红包",0,0.010d),
    bronze(5,"青铜粉丝奖 5元红包",110,0.020d),
    ;

    public final Integer id;

    public final String name;

    public final Integer totalCount;

    public final Double rate;

    Award(Integer id,String name,Integer totalCount,Double rate){
        this.id = id;
        this.name = name;
        this.totalCount= totalCount;
        this.rate = rate;
    }

    public static Award getById(Integer id){
        for (Award e : Award.values()) {
            if(e.id.equals(id)) {
                return e;
            }
        }
        return null;
    }
}
