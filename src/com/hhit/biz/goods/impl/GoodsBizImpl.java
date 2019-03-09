package com.hhit.biz.goods.impl;

import com.hhit.biz.goods.IGoodsBiz;
import com.hhit.dao.goods.IGoodsDao;
import com.hhit.dao.goods.impl.GoodsDaoImpl;
import com.hhit.vo.goods.Goods;

import java.util.List;

public class GoodsBizImpl implements IGoodsBiz {
    IGoodsDao goodsdao=new GoodsDaoImpl();
    @Override
    public Goods finById(int gid) {
        return goodsdao.findGood(gid);
    }

    @Override
    public List<Goods> getGoodsList() {
        return goodsdao.getGoodlist();
    }

}
