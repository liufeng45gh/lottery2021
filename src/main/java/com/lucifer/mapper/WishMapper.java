package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Wish;

import java.util.List;

@MapperScanSelf
public interface WishMapper {

     Integer insertWish(Wish wish);

    List<Wish> getWishNewList();

    List<Wish> getWishNewShowList();

    List<Wish> wishCmsSearch(String sql);

    Integer wishCmsSearchCount(String sql);

    Integer setShow(Wish wish);
}
