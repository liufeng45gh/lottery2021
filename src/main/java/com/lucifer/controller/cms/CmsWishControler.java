package com.lucifer.controller.cms;

import com.lucifer.mapper.WishMapper;
import com.lucifer.model.Member;
import com.lucifer.model.Wish;
import com.lucifer.model.user.SearchParam;
import com.lucifer.service.WishService;
import com.lucifer.utils.PageUtil;
import com.lucifer.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CmsWishControler {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    WishService wishService;

    @Resource
    WishMapper wishMapper;

    @RequestMapping(value="/cms/reward/wish-list",method = RequestMethod.GET)
    public String wishList(HttpServletRequest request, SearchParam param){

        logger.info("page :"+param.getPage());
        Integer perPageCount = 20;
        List<Wish> wishList=wishService.wishCmsSearch(param);
        Integer matchRecordCount=wishService.wishCmsSearchCount(param);
        Integer totalPageCount= PageUtil.getTotalPageCount(matchRecordCount, perPageCount);
        //request.setAttribute("totalPageCount", totalPageCount);
        request.setAttribute("wishList", wishList);
        PageUtil pageUtil = new PageUtil(request);
        String pageDiv = pageUtil.willPaginate(totalPageCount,  "pages_bar",new String []{"page","msg"});
        request.setAttribute("pageDiv",pageDiv);
        request.setAttribute("param",param);
        return "/cms/reward/wish-list";
    }

    @PostMapping("/cms/wish/set-show")
    @ResponseBody
    public Result setIsShow(Wish wish){
        wishMapper.setShow(wish);
        return Result.ok();
    }
}
