package com.hhit.biz.goods;

import com.hhit.vo.goods.Goods;

import java.util.List;

public interface IGoodsBiz {
    /**
     * 根据商品id获取商品
     * @param gid
     * @return
     */
    Goods finById(int gid);

    /**
     * 获得热推商品列表
     * @return
     */
    List<Goods> getGoodsList();

}
