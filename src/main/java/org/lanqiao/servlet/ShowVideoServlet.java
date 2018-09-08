package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.daoImpl.ShowVideoDaoImpl;
import org.lanqiao.entity.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ShowVideoServlet")
public class ShowVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int v_id = Integer.parseInt(request.getParameter("video_id"));
        ShowVideoDaoImpl u=new ShowVideoDaoImpl();
        List<Video> u1=u.showVideoType(v_id);
        String type1=u1.get(0).getVideo_type();
        List<Video> u2=u.showVideo(type1);
        JSONArray list = JSONArray.fromObject(u2);
       PrintWriter out=response.getWriter();
        out.print(list);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doPost(request,response);
    }
}
