package com.hhit.biz.feature;

import com.hhit.vo.feature.Feature;
import com.hhit.vo.goods.Goods;

import java.util.List;

public interface IFeatureBiz {
    /**
     * 查询所有的特色产品
     * @return
     */
    List<Feature>  findAllFeatures();

    /**
     * 分页查询特色产品
     * @param pageno
     * @param pagenum
     * @return
     */
    List<Feature> findPageFeatures(int pageno,int pagenum);

    /**
     * 计数总数
     * @return
     */
    int countAll();
}
