package com.lucifer.service;

import com.lucifer.mapper.WishMapper;
import com.lucifer.model.Member;
import com.lucifer.model.Wish;
import com.lucifer.model.user.SearchParam;
import com.lucifer.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WishService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    WishMapper wishMapper;

    public List wishCmsSearch(SearchParam param){
        String sql = "select w.*,m.nick_name from wish w  left outer join member m  on w.member_id = m.id  where 1=1 ";

        if (!StringHelper.isEmpty(param.getStatus())) {
            sql = sql + "and w.is_show = "+param.getStatus();
        }

        sql = sql + "  order by w.id desc limit "+param.getOffset()+","+param.getCount();



        logger.info("sql is : "+sql);

        List<Wish> wishList = wishMapper.wishCmsSearch(sql);



        return wishList;
    }

    public Integer wishCmsSearchCount(SearchParam param){
        String sql = "select count(*) from wish  where 1=1 ";
        if (!StringHelper.isEmpty(param.getStatus())) {
            sql = sql + "and is_show = "+param.getStatus();
        }


        logger.info("sql is : "+sql);

        Integer recordCount  = wishMapper.wishCmsSearchCount(sql);


        return recordCount;
    }
}
