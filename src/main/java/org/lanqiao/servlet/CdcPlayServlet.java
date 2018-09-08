package org.lanqiao.servlet;

import net.sf.json.JSONArray;
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

@WebServlet("/CdcPlayServlet")
public class CdcPlayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1.获取表单数据
        int id = Integer.parseInt(request.getParameter("video_id"));
//2.封装数据
//3.dao
        VideoDaoImpl retVideo = new VideoDaoImpl();
        List<Video> list = retVideo.cdc_findById(id);
//4.out
        PrintWriter out =response.getWriter();
        out.print(JSONArray.fromObject(list));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
