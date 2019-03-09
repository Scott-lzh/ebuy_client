package com.hhit.servlet.cart;

import com.hhit.biz.cart.ICartBiz;
import com.hhit.biz.cart.impl.CartBizImpl;
import com.hhit.vo.cart.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet",value = "/cart.do")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type = -1;
        try {
            type = Integer.parseInt(request.getParameter("type"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ICartBiz cartbiz=new CartBizImpl();
        int uid;
        switch (type) {
            case 0:
                //判断是否在登陆
                //登陆
                    //保证和session里面的uid是否一致、gid无碍
                Cookie[] cookies = request.getCookies();
                Cookie cookie=null;
                for (Cookie cook : cookies) {
                    if(cook.getName().equals("username")){
                        cookie=cook;
                        break;
                    }
                }
                //首先判断是否存在cookie、然后判断是否和会话是同一个用户
                if(cookie!=null&&request.getSession().getAttribute("uname").equals(cookie.getValue())){
                    uid = (int)request.getSession().getAttribute("uid");
                    int gid=Integer.parseInt(request.getParameter("gid"));
                    //加入购物车
                    cartbiz.addByGid(uid,gid);
                    //重定向、显示购物车界面
                    response.sendRedirect("/demo/cart.do?type=1");
                }else {
                    //未登陆、返回登陆界面
                    response.sendRedirect("/demo/denglu.jsp");
                }
                break;
            case 1:
                    //显示购物车界面
                    uid = (int)request.getSession().getAttribute("uid");
                    List<Cart> cartList = cartbiz.findByUid(uid);
                    request.setAttribute("cartList",cartList);
                    request.getRequestDispatcher("/ddtj.jsp").forward(request,response);
                break;
            default:
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
