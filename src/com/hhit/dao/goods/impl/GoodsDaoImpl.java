package com.hhit.dao.goods.impl;

import com.hhit.dao.BaseDao;
import com.hhit.dao.goods.IGoodsDao;
import com.hhit.vo.goods.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements IGoodsDao {
    @Override
    public Goods findGood(int gid)
    {
        Goods good=null;
        String sql="select eb_goodsid, eb_goodsname, eb_goodstypeid, eb_goodscredits, eb_goodsprice, eb_goodssynopsis, eb_goodsarea from eb_goods "
                +" where eb_goodsid=?";
        Object[] parms={gid};
        res=executeQuery(sql,parms);
        try {
            if(false!=res.next()){
                    good=new Goods();
                    good.setId(gid);
                    good.setName(res.getString("eb_goodsname"));
                    good.setTypeId(res.getInt("eb_goodstypeid"));
                    good.setCredits(res.getInt("eb_goodscredits"));
                    good.setPrice(res.getDouble("eb_goodsprice"));
                    good.setSynopsis(res.getString("eb_goodssynopsis"));
                    good.setArea(res.getString("eb_goodsarea"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return good;
    }

    @Override
    public List<Goods> getGoodlist() {
        Goods good = null;

        List<Goods> goodlist = new ArrayList<>();


        String sql= "  select eb_goodsid,eb_goodsname,eb_goodstypeid,eb_goodscredits,eb_goodsprice,"
                    +"  eb_goodssynopsis,eb_goodsarea  from eb_recom inner join eb_goods  on eb_recomgoodsid=eb_goodsid "
                    +"  where eb_recomrank=1 order by eb_goodstypeid,eb_recomrank ";
        Object params[] = null;
        res = super.executeQuery(sql, params);
        try {
            while(res.next()){
                good = new Goods();
                good.setId(res.getInt("eb_goodsid"));
                good.setName(res.getString("eb_goodsname"));
                good.setTypeId(res.getInt("eb_goodstypeid"));
                good.setCredits(res.getInt("eb_goodscredits"));
                good.setPrice(res.getDouble("eb_goodsprice"));
                good.setSynopsis(res.getString("eb_goodssynopsis"));
                good.setArea(res.getString("eb_goodsarea"));
                goodlist.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return goodlist;
    }
}
