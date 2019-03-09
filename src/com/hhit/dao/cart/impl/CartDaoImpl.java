package com.hhit.dao.cart.impl;

import com.hhit.dao.BaseDao;
import com.hhit.dao.cart.ICartDao;
import com.hhit.vo.cart.Cart;
import com.hhit.vo.goods.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends BaseDao implements ICartDao {

    @Override
    public int insertByGid(int uid, int gid) {
        String sql="insert into eb_cart values(seq_cartid.nextval,?,?,null)";
        Object[] parms={uid,gid};
        return executeUpdate(sql,parms);
    }

    @Override
    public List<Cart> findCartList(int uid) {
        String sql="select t.*,eb_featureprice from (select eb_cartid, eb_goodid, eb_goodsname,eb_goodscredits, eb_goodsprice, " +
                "   eb_goodssynopsis, eb_goodsarea from eb_cart inner join eb_goods on eb_goodid=eb_goodsid where eb_userid=?)t" +
                "   left join eb_feature on t.eb_goodid=eb_featureid";
        Object[] parms={uid};
        double price;
        List<Cart> cartsList=new ArrayList<>();
        Cart cart=null;
        Goods good=null;
        res = executeQuery(sql, parms);
        try {
            while(res.next()){
                cart =new Cart();
                cart.setId(res.getInt("eb_cartid"));
                good=new Goods();
                good.setId(res.getInt("eb_goodid"));
                good.setName(res.getString("eb_goodsname"));
                good.setCredits(res.getInt("eb_goodscredits"));
                price=res.getDouble("eb_featureprice");
                if(price==0){
                    price=res.getDouble("eb_goodsprice");
                }
                good.setPrice(price);
                good.setSynopsis(res.getString("eb_goodssynopsis"));
                good.setArea(res.getString("eb_goodsarea"));
                cart.setGood(good);
                cartsList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return cartsList;
    }
}
