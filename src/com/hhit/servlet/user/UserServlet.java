package com.hhit.servlet.user;

import com.hhit.biz.user.IUserBiz;
import com.hhit.biz.user.impl.UserBizImpl;
import com.hhit.vo.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UserServlet",value="/user.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type=Integer.parseInt(request.getParameter("type"));
        IUserBiz userbiz =new UserBizImpl();
        switch (type){
            case 0:
                String username=request.getParameter("key");
                String pwd=request.getParameter("pwd");
                String userByWher = userbiz.getUserByWher(username, pwd);
                System.out.println(userByWher);
                if(null!=userByWher){
                    User user= userbiz.findUserByName(userByWher);
                    //新建cookie、存放username
                    Cookie cookie = new Cookie("username", username);
                    //cookie设置超时时间
                    cookie.setMaxAge(5*60);
                    response.addCookie(cookie);
                    //新建session、存放uid
                    HttpSession session = request.getSession();
                    //session设置5分钟的超市时间
                    session.setMaxInactiveInterval(5*60);
                    session.setAttribute("uid",user.getId());
                    session.setAttribute("uname",username);
                    //转发主页
                    request.getRequestDispatcher("/type.do?type=0").forward(request,response);
                }else {
                    response.sendRedirect("/demo/denglu.jsp");
                }
                break;
            case 1:
                break;
            default:
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
