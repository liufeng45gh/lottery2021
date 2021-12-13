package com.lucifer.controller;

import com.lucifer.config.ImageConfig;
import com.lucifer.enumeration.Award;
import com.lucifer.exception.AwardException;
import com.lucifer.exception.NotLoginException;
import com.lucifer.mapper.AwardMapper;
import com.lucifer.mapper.MemberMapper;
import com.lucifer.model.Member;
import com.lucifer.model.MemberAward;
import com.lucifer.service.LotteryService;
import com.lucifer.service.WxService;
import com.lucifer.utils.Result;
import com.lucifer.utils.StringHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LotteryController {

    @Resource
    AwardMapper awardMapper;

    @Resource
    WxService wxService;

    @Resource
    MemberMapper memberMapper;

    @Resource
    LotteryService lotteryService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        request.setAttribute("resource", ImageConfig.resource);
        return "/web/index";
    }

    @GetMapping("/win")
    public String win(@RequestParam (value = "id") Integer id, HttpServletRequest request){
        Award award = Award.getById(id);
        String cardName = "card-"+id+".png";
        String cardText = award.name;
        request.setAttribute("cardName",cardName);
        request.setAttribute("cardText",cardText);
        return "/web/win";
    }


    @GetMapping("/my")
    public String my(@CookieValue(value = "token",required = false) String token,HttpServletRequest request) throws NotLoginException {

        String userId = wxService.getIdByToken(token);
        if (StringHelper.isEmpty(userId)) {
            throw new NotLoginException("can not find user by token  : " + token);
        }

        Long memberId = Long.valueOf(userId);
        List<MemberAward> memberAwards = awardMapper.getMemberAwardCount(memberId);
        for (MemberAward memberAward : memberAwards) {
            request.setAttribute("award_" + memberAward.getAwardId(),memberAward.getCount());
        }
        Member member = memberMapper.getMemberById(memberId);
        request.setAttribute("member",member);
        return "/web/my";
    }

    @GetMapping("/my-residue-count")
    @ResponseBody
    public Result myResidueCount(@CookieValue(value = "token",required = false) String token) throws NotLoginException {
        String userId = wxService.getIdByToken(token);
        if (StringHelper.isEmpty(userId)) {
            throw new NotLoginException("can not find user by token  : " + token);
        }

        Long memberId = Long.valueOf(userId);
        Long count = lotteryService.getMemberLotteryCount(memberId);
        long residue = 3l - count;
        if (residue < 0) {
            residue = 0;
        }
        return Result.ok(residue);
    }

    @PostMapping(value = "/do-lottery")
    @ResponseBody
    public Result doLottery(@CookieValue(value = "token",required = false) String token) throws NotLoginException, AwardException {
        return lotteryService.doLottery(token);
    }


}
