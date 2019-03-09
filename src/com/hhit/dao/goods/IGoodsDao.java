package com.hhit.dao.goods;

import com.hhit.vo.goods.Goods;

import java.util.List;

public interface IGoodsDao {
    /**
     * 根据商品ID查询商品
     * @param gid
     * @return
     */
    Goods findGood(int gid);

    /**
     * 获得所有热推(rank=1)商品列表
     * @return
     */
    public List<Goods> getGoodlist();
}
