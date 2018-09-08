package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.ShowMessageDaoImpl;
import org.lanqiao.entity.Message;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/ShowMessageServlet")
public class ShowMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenumber = request.getParameter("pagenumber");
        int pnumber = Integer.parseInt(pagenumber);
        ShowMessageDaoImpl showMessageDaoImpl1 = new ShowMessageDaoImpl();
        //查询分页数据
        List<Message> list = showMessageDaoImpl1.showMsg(pnumber,6);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        int rsCount = showMessageDaoImpl1.getCommentCount();
        jsonArray.add(rsCount);
//        System.out.println(rsCount);
        //json发送到前端
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
