package org.lanqiao.servlet;



import org.lanqiao.daoImpl.InsertMessageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg_text = request.getParameter("msg_text");//获取留言
        int v_id = Integer.parseInt(request.getParameter("video_id"));
        int u_id = Integer.parseInt(request.getParameter("user_id"));
//        System.out.println("msg_text" + msg_text);

        InsertMessageDaoImpl insertMessageDaoImpl = new InsertMessageDaoImpl();
        int i = insertMessageDaoImpl.InsertMsg(v_id,u_id,msg_text);
//        System.out.println(i);
        PrintWriter out = response.getWriter();
        out.print(i+"");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
