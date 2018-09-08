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

@WebServlet("/GetVideo_idByVideo_nameServlet")
public class GetVideo_idByVideo_nameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String video_name = request.getParameter("video_name");
        VideoDaoImpl videoDao = new VideoDaoImpl();
        //根据video_name查询video_id
        List<Video> list = videoDao.getIdByVideo_name(video_name);
        //将video_id存入session
        int v_id = list.get(0).getVideo_id();
        request.getSession().setAttribute("videosession",v_id);
        //返回update playtimes受影响条数
        int retnum = videoDao.updateVideo_playtimes(video_name);
        //发送到html
        JSONArray jsonArray = JSONArray.fromObject(list);
        jsonArray.add(retnum);
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

}
