package com.hhit.servlet.goods;

import com.hhit.biz.goods.IGoodsBiz;
import com.hhit.biz.goods.impl.GoodsBizImpl;
import com.hhit.dao.goods.impl.GoodsDaoImpl;
import com.hhit.vo.feature.Feature;
import com.hhit.vo.goods.Goods;
import com.hhit.vo.type.Type;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GoodsServlet",value="/goods.do")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        int choose=-1;
        try {
            choose = Integer.parseInt(type);
        }catch (Exception e){
            e.printStackTrace();
        }

        switch (choose){
            case 0:
                IGoodsBiz goodsBiz=new GoodsBizImpl();
                List<Goods> goodslist = goodsBiz.getGoodsList();
                JSONArray jsonnode = JSONArray.fromObject(goodslist);
                JSONObject json = new JSONObject();
                json.accumulate("goodslist", jsonnode);
                response.getWriter().write(json.toString());
                break;
            case 1:
                int gid=-1;
                try {
                    gid = Integer.parseInt(request.getParameter("gid"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                Feature feature=new Feature();
                feature.setPrice(Double.parseDouble(request.getParameter("price")));
                feature.setReason(request.getParameter("reason"));
                Goods good=new Goods();
                good.setId(gid);
                good.setArea(request.getParameter("area"));
                good.setSynopsis(request.getParameter("synopsis"));
                good.setPrice(Double.parseDouble(request.getParameter("oldprice")));
                good.setCredits(Integer.parseInt(request.getParameter("credit")));
                good.setName(request.getParameter("name"));
                feature.setGood(good);
                request.setAttribute("feature",feature);
                request.getRequestDispatcher("/cpxq.jsp").forward(request,response);
                break;
            default:
                break;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
