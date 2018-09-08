package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.entity.History;
import org.lanqiao.serviceImpl.HistoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CdcOutXuboServlet")
public class CdcOutXuboServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取表单数据
        int v_id = Integer.parseInt(request.getParameter("video_id"));
        int u_id = Integer.parseInt(request.getParameter("user_id"));
        //2.封装数据
        //3.dao
        HistoryServiceImpl retHistory = new HistoryServiceImpl();
        List<History>  historyList = retHistory.cdc_OutHistory(u_id,v_id);
        //4.out
        PrintWriter out =response.getWriter();
        out.print(JSONArray.fromObject(historyList));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
