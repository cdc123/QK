package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.VideoDaoImpl;
import org.lanqiao.entity.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/zmm_ShowVideoServlet")
public class zmm_ShowVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenumber = request.getParameter("pagenumber");
        int pnumber = Integer.parseInt(pagenumber);
        VideoDaoImpl showMessageDaoImpl1 = new VideoDaoImpl();
        //查询分页数据
        List<Video> list1 = showMessageDaoImpl1.showVideo(pnumber,8);

        JsonConfig jsonConfig = new JsonConfig();
        JSONArray list = JSONArray.fromObject(list1, jsonConfig);
        int rsCount = showMessageDaoImpl1.getCommentCount();
        list.add(rsCount);
//        System.out.println(rsCount);
        //json发送到前端
        PrintWriter out = response.getWriter();
        out.print(list);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
