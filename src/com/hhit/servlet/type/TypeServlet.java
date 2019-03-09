package com.hhit.servlet.type;

import com.hhit.biz.type.ITypeBiz;
import com.hhit.biz.type.impl.TypeBizImpl;
import com.hhit.dao.type.ITypeDao;
import com.hhit.dao.type.impl.TypeDaoImpl;
import com.hhit.vo.goods.Goods;
import com.hhit.vo.type.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TypeServlet",value="/type.do")
public class TypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type=Integer.parseInt(request.getParameter("type"));
        switch (type){
            case  0:
                ITypeBiz typeDao = new TypeBizImpl();
                List<Type> typeList = typeDao.findFront();
                for (Type ty : typeList) {
                    List<Goods> goodsList = ty.getGoodsList();
                    ty.setGoodsList(goodsList);
                }
                request.setAttribute("typeList",typeList);
                request.setAttribute("sum",typeList.size());
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
