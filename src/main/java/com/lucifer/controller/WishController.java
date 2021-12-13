package com.lucifer.controller;

import com.lucifer.exception.NotLoginException;
import com.lucifer.mapper.WishMapper;
import com.lucifer.model.Wish;
import com.lucifer.service.WxService;
import com.lucifer.utils.Result;
import com.lucifer.utils.StringHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WishController {

    @Resource
    WxService wxService;

    @Resource
    WishMapper wishMapper;

    @PostMapping(value = "/wish/commit")
    public Result put(@RequestParam String text, @CookieValue(value = "token",required = false) String token) throws NotLoginException {
        if (StringHelper.isEmpty(text)) {
            return Result.fail("text can not be null");
        }
        String userId = wxService.getIdByToken(token);
        if (StringHelper.isEmpty(userId)) {
            throw new NotLoginException("can not find user by token  : " + token);
        }
        Wish wish = new Wish();
        wish.setText(text);
        Long memberId = Long.valueOf(userId);
        wish.setMemberId(memberId);
        wishMapper.insertWish(wish);
        return Result.ok();
    }

    @GetMapping(value = "/wish/list")
    public List<Wish> wishList(){
        return wishMapper.getWishNewShowList();
    }
}
