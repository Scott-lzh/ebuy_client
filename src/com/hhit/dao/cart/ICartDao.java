package com.hhit.dao.cart;

import com.hhit.vo.cart.Cart;
import com.hhit.vo.goods.Goods;

import java.util.List;

public interface ICartDao {
    int insertByGid(int uid,int gid);

    /**
     * 查找Cart列表
     * @param uid
     * @return
     */
    List<Cart> findCartList(int uid);
}
