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

@WebServlet("/HomeShowServlet")
public class HomeShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String v_sort = request.getParameter("video_sort");
        VideoDaoImpl videoDao = new VideoDaoImpl();
        List<Video> list = videoDao.cdc_fingByIdSort(v_sort);
        PrintWriter out =response.getWriter();
        out.print(JSONArray.fromObject(list));
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
