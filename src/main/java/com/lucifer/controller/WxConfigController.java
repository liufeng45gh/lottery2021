package com.lucifer.controller;


import com.lucifer.service.WxConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by liufx on 2017/4/13.
 */
@Controller
public class WxConfigController {

    @Resource
    private WxConfigService wxConfigService;


    @RequestMapping(value="/wx-config",method= RequestMethod.POST)
    @ResponseBody
    public Map getWxConfig(@RequestParam String shareUrl){
       return wxConfigService.getWxConfig(shareUrl);
    }
}
