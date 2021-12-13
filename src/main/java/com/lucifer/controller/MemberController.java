package com.lucifer.controller;

import com.lucifer.exception.ArgumentException;
import com.lucifer.exception.UnexpectedException;
import com.lucifer.model.Member;
import com.lucifer.service.MemberService;
import com.lucifer.utils.Constant;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class MemberController {

    @Resource
    MemberService memberLoginService;

    @RequestMapping(value = "/user-info",method = RequestMethod.GET)
    public String showUserInfo(){
        return   "/web/user-info";
    }

    @RequestMapping(value = "/get-member-by-token",method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberByToken(@CookieValue(Constant.TOKEN) String token) throws ArgumentException, UnexpectedException {

        if (null == token) {
            throw new ArgumentException("header token can not be null");
        }
        Member member = memberLoginService.getMemberByToken(token);
        return Result.ok(member);
    }

    @RequestMapping(value = "/member-info",method = RequestMethod.POST)
    @ResponseBody
    public Result updateMemberInfo(@CookieValue(Constant.TOKEN) String token,Member member) throws UnexpectedException {
        memberLoginService.updateMemberInfo(token,member);
        return   Result.ok();
    }
}
