package com.lucifer.controller.cms;



import com.lucifer.mapper.MemberMapper;

import com.lucifer.model.Member;
import com.lucifer.model.user.SearchParam;

import com.lucifer.service.MemberService;

import com.lucifer.utils.PageUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by Administrator on 2016/6/30.
 */


@Controller
public class CmsMemberController {

    @Resource
    private MemberService memberService;

    @Resource
    private MemberMapper memberMapper;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("unchecked")
    @RequestMapping(value="/cms/member/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request, SearchParam param){
        logger.info("page :"+param.getPage());
        Integer perPageCount = 20;
        @SuppressWarnings("rawtypes")


        List<Member> memberList=memberService.memberCmsSearch(param);
        Integer matchRecordCount=memberService.userCmsSearchCount(param);
        Integer totalPageCount=PageUtil.getTotalPageCount(matchRecordCount, perPageCount);
        //request.setAttribute("totalPageCount", totalPageCount);
        request.setAttribute("memberList", memberList);
        PageUtil pageUtil = new PageUtil(request);
        String pageDiv = pageUtil.willPaginate(totalPageCount,  "pages_bar",new String []{"page","msg"});
        request.setAttribute("pageDiv",pageDiv);
        request.setAttribute("param",param);
        return "/cms/member/list";
    }


}
