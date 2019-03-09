package com.hhit.biz.cart;

import com.hhit.vo.cart.Cart;

import java.util.List;

public interface ICartBiz {
    /**
     * 添加购物车
     * @param uid
     * @param gid
     * @return
     */
    int addByGid(int uid,int gid);

    /**
     * 根据uid查询购物车
     * @param uid
     * @return
     */
    List<Cart> findByUid(int uid);
}
