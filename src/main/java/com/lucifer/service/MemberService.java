package com.lucifer.service;

import com.lucifer.exception.UnexpectedException;
import com.lucifer.mapper.MemberMapper;

import com.lucifer.model.Member;

import com.lucifer.model.user.SearchParam;
import com.lucifer.model.user.User;
import com.lucifer.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MemberService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private WxService wxService;



    public Member getMemberByToken(String token) throws UnexpectedException {
        String stringId = wxService.getIdByToken(token);
        if (stringId == null) {
            throw new UnexpectedException(" memberId can not find by token: " + token);
        }

        Long Id = Long.valueOf(stringId);
        Member member = memberMapper.getMemberById(Id);
        if (null == member) {
            throw new UnexpectedException(" member can not find by id: " + stringId);
        }
        return member;
    }

    public void updateMemberInfo(String token,Member member) throws UnexpectedException {
        String stringId = wxService.getIdByToken(token);
        if (stringId == null) {
            throw new UnexpectedException(" memberId can not find by token: " + token);
        }
        Long id = Long.valueOf(stringId);
        member.setId(id);
        memberMapper.updateMemberInfo(member);
    }


    public List memberCmsSearch(SearchParam param){
        String sql = "select * from member   where 1=1 ";
        if (!StringHelper.isEmpty(param.getPhone())) {
            sql = sql + "and member.phone like '"+param.getPhone()+"%' ";
        }
        if (!StringHelper.isEmpty(param.getNickName())) {
            sql = sql + "and member.nick_name like '"+param.getNickName()+"%' ";
        }


        sql = sql + "order by member.id desc limit "+param.getOffset()+","+param.getCount();



        logger.info("sql is : "+sql);

        List<Member> memberList = memberMapper.memberCmsSearch(sql);



        return memberList;
    }

    public Integer userCmsSearchCount(SearchParam param){
        String sql = "select count(*) from member  where 1=1 ";
        if (!StringHelper.isEmpty(param.getPhone())) {
            sql = sql + "and member.phone like '"+param.getPhone()+"%' ";
        }
        if (!StringHelper.isEmpty(param.getNickName())) {
            sql = sql + "and member.nick_name like '"+param.getNickName()+"%' ";
        }


        logger.info("sql is : "+sql);

        Integer recordCount  = memberMapper.memberCmsSearchCount(sql);


        return recordCount;
    }

}
