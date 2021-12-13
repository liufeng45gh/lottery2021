package com.lucifer.controller.cms;

import com.lucifer.mapper.AwardMapper;
import com.lucifer.model.AwardDayConfig;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CmsLotteryController {

    @Resource
    AwardMapper awardMapper;

    @RequestMapping(value="/cms/reward/list",method = RequestMethod.GET)
    public String list(HttpServletRequest request){
        List<List> rewardList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            List memberList = awardMapper.rewardList(i);
                    //new ArrayList();
            rewardList.add(memberList);
        }
        request.setAttribute("rewardList",rewardList);
        return "/cms/reward/list";
    }

    @RequestMapping(value="/cms/reward/day-list",method = RequestMethod.GET)
    public String dayList(HttpServletRequest request){
        List<String> dayList = awardMapper.getAwardDayList();
                //new ArrayList<>();

        request.setAttribute("dayList",dayList);
        return "/cms/reward/day-list";
    }

    @RequestMapping(value="/cms/reward/day-add",method = RequestMethod.POST)
    public String dayAdd(HttpServletRequest request,@RequestParam String day){
        awardMapper.insertAwardDay(day);
        return"redirect:/cms/reward/day-list" ;
    }

    @RequestMapping(value="/cms/reward/day-delete",method = RequestMethod.POST)
    @ResponseBody
    public Result dayDelete(HttpServletRequest request,@RequestParam String day){
        awardMapper.deleteAwardDay(day);
        return Result.ok() ;
    }

    @RequestMapping(value="/cms/reward/day-config-list",method = RequestMethod.GET)
    public String dayConfigList(HttpServletRequest request){
        List<AwardDayConfig> awardDayConfigList = awardMapper.getAllAwardDayConfigList();
                //awardMapper.getAwardDayList();
        //new ArrayList<>();

        request.setAttribute("awardDayConfigList",awardDayConfigList);
        return "/cms/reward/day-config-list";
    }

}
