package com.hhit.dao.type.impl;
import com.hhit.dao.BaseDao;
import com.hhit.dao.type.ITypeDao;
import com.hhit.vo.goods.Goods;
import com.hhit.vo.type.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl extends BaseDao implements ITypeDao {
    @Override
    public List<Type> findType() {
        Type type=null;
        Goods good=null;
        List<Type> list=new ArrayList<>();
        List<Goods> glist=new ArrayList<>();
        String sql="  select eb_recomrank,eb_recompic,eb_goodsid,eb_goodsname,eb_goodstypeid,eb_goodscredits,eb_goodsprice," +
                "eb_goodssynopsis,eb_goodsarea  from eb_recom inner join eb_goods  on eb_recomgoodsid=eb_goodsid " +
                "  order by eb_goodstypeid,eb_recomrank ";
        Object[] parms=null;
        int pre=-1;
        int id=0;
        res=executeQuery(sql,parms);
        try {
            while(res.next()){
                id=res.getInt("eb_goodstypeid");
                if(id!=pre){
                    type=new Type();
                    glist=new ArrayList<>();
                    type.setGoodsList(glist);
                    type.setId(id);
                    list.add(type);
                    pre=id;
                }
                good=new Goods();
                good.setId(id);
                good.setName(res.getString("eb_goodsname"));
                good.setTypeId(res.getInt("eb_goodstypeid"));
                good.setCredits(res.getInt("eb_goodscredits"));
                good.setPrice(res.getDouble("eb_goodsprice"));
                good.setSynopsis(res.getString("eb_goodssynopsis"));
                good.setArea(res.getString("eb_goodsarea"));
                type.getGoodsList().add(good);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    @Override
    public Type findById(int id) {
        Type type=null;
        String sql="select eb_typename from eb_type where eb_typeid=?";
        Object[] parms={id};
        res=executeQuery(sql,parms);
        try {
            if(res.next()){
                type=new Type();
                type.setName(res.getString("eb_typename"));
                type.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
            return type;
    }
}
