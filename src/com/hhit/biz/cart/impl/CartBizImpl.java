package com.hhit.biz.cart.impl;

import com.hhit.biz.cart.ICartBiz;
import com.hhit.dao.cart.ICartDao;
import com.hhit.dao.cart.impl.CartDaoImpl;
import com.hhit.vo.cart.Cart;

import java.util.List;

public class CartBizImpl implements ICartBiz {
    ICartDao cartdao=new CartDaoImpl();
    @Override
    public int addByGid(int uid, int gid) {

        return cartdao.insertByGid(uid,gid);
    }

    @Override
    public List<Cart> findByUid(int uid) {
        return cartdao.findCartList(uid);
    }
}
