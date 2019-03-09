package com.hhit.dao.feature.impl;

import com.hhit.dao.BaseDao;
import com.hhit.dao.feature.IFeatureDao;
import com.hhit.vo.feature.Feature;
import com.hhit.vo.goods.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeatureDaoImpl extends BaseDao implements IFeatureDao {
    @Override
    public List<Feature> findAll()  {
        //定义集合
        List<Feature> list=new ArrayList<>();
        Feature feature=null;
        Goods good=null;
        //定义sql语句
        String sql="select eb_featureid, eb_featureprice, eb_featurereason from eb_feature";
        //定义参数
        Object[] parms={};
        res=executeQuery(sql,parms);
        try {
             while(false!=res.next()){
                 feature=new Feature();
                 good=new Goods();
                 good.setId(res.getInt("eb_featureid"));
                 feature.setGood(good);
                 feature.setPrice(res.getDouble("eb_featureprice"));
                 feature.setReason(res.getString("eb_featurereason"));
                 list.add(feature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }

        return list;
    }

    @Override
    public int countAll() {
        String sql="select count(1) cou  from eb_feature";
        Object[] parms=null;
        res=executeQuery(sql,parms);
        try {
            if(res.next()){
                return res.getInt("cou");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Feature> findPage(int pageno, int pagenum) {
        List<Feature> list=new ArrayList<>();
        Goods good=null;
        Feature feature=null;
        String sql="select egt.* " +
                "from (select  eb_featureprice, eb_featurereason,Rownum rn,eg.* " +
                "from eb_feature  " +
                "inner join eb_goods eg on eb_featureid=eb_goodsid " +
                "where rownum<=(?*?))egt " +
                "where rn>(?*?)";
        Object[] parms={pageno,pagenum,pageno-1,pagenum};
        res=executeQuery(sql,parms);
        try {
            while(res.next()){
                feature=new Feature();
                good=new Goods();
                good.setId(res.getInt("eb_goodsid"));
                good.setName(res.getString("eb_goodsname"));
                good.setTypeId(res.getInt("eb_goodstypeid"));
                good.setCredits(res.getInt("eb_goodscredits"));
                good.setPrice(res.getDouble("eb_goodsprice"));
                good.setSynopsis(res.getString("eb_goodssynopsis"));
                good.setArea(res.getString("eb_goodsarea"));
                feature.setGood(good);
                feature.setPrice(res.getDouble("eb_featureprice"));
                feature.setReason(res.getString("eb_featurereason"));
                list.add(feature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }
}
