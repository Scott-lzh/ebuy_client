package com.hhit.servlet.mesg;

import com.hhit.biz.Mesg.IMesgBiz;
import com.hhit.biz.Mesg.impl.MesgBizImpl;
import com.hhit.vo.mesg.Mesg;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;
@WebServlet(name="MesgServlet",value="/mesg.do")
public class MesgServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        int type=Integer.parseInt(request.getParameter("type"));
        switch (type){
            case 0:
                IMesgBiz imBiz = new MesgBizImpl();
                Integer pageNo = 0;
                // 创建页码变量
                try {
                    pageNo = Integer.valueOf(request.getParameter("pageNo"));
                } catch (NumberFormatException e) {
                    pageNo = 1;
                }
                //创建数据条目
                final int PAGESIZE = 4;
                int mesCount = imBiz.getMesgNum();
                int sumPage = 0;
                if(mesCount % PAGESIZE == 0) {
                    sumPage	= mesCount / PAGESIZE;
                }else {
                    sumPage	= mesCount / PAGESIZE + 1;
                }

                List<Mesg> mesgs = imBiz.showMesgs(pageNo,PAGESIZE);
                request.setAttribute("pageNo", pageNo);
                request.setAttribute("sumPage", sumPage);
                request.setAttribute("mesCount", mesCount);
                request.setAttribute("size", PAGESIZE);
                request.setAttribute("mesgs", mesgs);

                request.getRequestDispatcher("/newslist.jsp").forward(request, response);
                break;
            case 1:
                String mid = request.getParameter("mid");
                IMesgBiz imb = new MesgBizImpl();
                Mesg mesg = imb.getMesgById(Integer.valueOf(mid));
                request.setAttribute("mesg", mesg);

                request.getRequestDispatcher("about.jsp").forward(request,response);
                break;
            default:
                break;
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
