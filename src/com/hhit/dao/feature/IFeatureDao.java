package com.hhit.dao.feature;

import com.hhit.vo.feature.Feature;
import com.hhit.vo.goods.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IFeatureDao {
    /**
     * 查询所有的特色商品
     * @return
     */
    List<Feature> findAll();

    /**
     * 计算所有的条数
     * @return
     */
    int countAll();

    /**
     * 查找分页
     * @param pageno
     * @param pagenum
     * @return
     */
    List<Feature> findPage(int pageno,int pagenum);
}
