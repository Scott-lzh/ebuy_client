package com.hhit.biz.feature.impl;

import com.hhit.biz.feature.IFeatureBiz;
import com.hhit.dao.feature.IFeatureDao;
import com.hhit.dao.feature.impl.FeatureDaoImpl;
import com.hhit.vo.feature.Feature;
import com.hhit.vo.goods.Goods;

import java.util.Iterator;
import java.util.List;

public class FeatureBizImpl implements IFeatureBiz {
    IFeatureDao featuredao=new FeatureDaoImpl();
    @Override
    public List<Feature> findAllFeatures() {
        return featuredao.findAll();
    }

    @Override
    public List<Feature> findPageFeatures(int pageno, int pagenum) {
      return  featuredao.findPage(pageno,pagenum);

    }

    @Override
    public int countAll() {
        return featuredao.countAll();
    }
}
