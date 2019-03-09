package com.hhit.servlet.feature;

import com.hhit.biz.feature.IFeatureBiz;
import com.hhit.biz.feature.impl.FeatureBizImpl;
import com.hhit.dao.goods.impl.GoodsDaoImpl;
import com.hhit.vo.feature.Feature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FeatureServlet",value = "/feature.do")
public class FeatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type=Integer.parseInt(request.getParameter("type"));
        switch (type){
            case 0:
                int pageno = 0;
                int pagenum= 6;
                int totalno=0;
                IFeatureBiz featureBiz = new FeatureBizImpl();
                try {
                    pageno = Integer.parseInt(request.getParameter("pageno"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                List<Feature> FeatureList =featureBiz.findPageFeatures(pageno, pagenum);
                int totalnum=featureBiz.countAll();
                totalno=(totalnum+pagenum-1)/pagenum;
                request.setAttribute("totalno",totalno);
                request.setAttribute("pageno",pageno);
                request.setAttribute("pagenum",(pageno<totalno)?pagenum:totalnum%pagenum);
                request.setAttribute("FeatureList",FeatureList);
                request.getRequestDispatcher("/tplist.jsp").forward(request,response);
                 break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
