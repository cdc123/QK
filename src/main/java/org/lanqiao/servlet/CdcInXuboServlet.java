package org.lanqiao.servlet;


import org.lanqiao.entity.History;
import org.lanqiao.serviceImpl.HistoryServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/CdcInXuboServlet")
public class CdcInXuboServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.获取表单数据
        double holder = Double.parseDouble(request.getParameter("history_holder"));
        double total = Double.parseDouble(request.getParameter("history_total"));
        int v_id = Integer.parseInt(request.getParameter("video_id"));
        int u_id = Integer.parseInt(request.getParameter("user_id"));
//2.封装数据
        History history = new History(holder,total);
//3.dao
        HistoryServiceImpl retHistory = new HistoryServiceImpl();
        int i = retHistory.cdc_InHistory(u_id,v_id ,history);
//4.out
        PrintWriter out =response.getWriter();
        out.print(i+"");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
