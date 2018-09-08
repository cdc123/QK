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

@WebServlet("/SearchVideoServlet")
public class SearchVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String video_name = request.getParameter("video_name");
            VideoDaoImpl videoDao = new VideoDaoImpl();
            List<Video> search_result = videoDao.searchVideo(video_name);
            JSONArray jsonArray = JSONArray.fromObject(search_result);
            PrintWriter out = response.getWriter();
            out.print(jsonArray);
            out.flush();
            out.close();
    }
}
