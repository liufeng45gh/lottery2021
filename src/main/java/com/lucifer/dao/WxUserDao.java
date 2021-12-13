package com.lucifer.dao;


import com.lucifer.dao.cms.IBatisBaseDao;

import com.lucifer.model.WxInfo;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/24.
 */
@Component
public class WxUserDao extends IBatisBaseDao {

    public WxInfo getWxUserByWxId(String wxId){
        return this.sqlSession.selectOne("getWxUserByWxId",wxId);
    }

    public Integer insertWxUser(WxInfo wxInfo){
        return this.sqlSession.insert("insertWxUser",wxInfo);
    }
}
