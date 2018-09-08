package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.entity.Video;
import org.lanqiao.serviceImpl.Wcg_VideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Wcg_SearchVideo")
public class Wcg_SearchVideo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        if (flag.equals("getVideoFirstByName")) {/*模糊查找*/
            String vName = request.getParameter("videoName");
            Wcg_VideoServiceImpl wvsi = new Wcg_VideoServiceImpl();
            List<String> al = wvsi.getVideoFirstByName(vName);
            JSONArray jAry = JSONArray.fromObject(al);
            out.print(jAry);
        } else if (flag.equals("getVideoByName")) {/*精确查找*/
            String vName = request.getParameter("videoName");
            Wcg_VideoServiceImpl wvsi = new Wcg_VideoServiceImpl();
            List<Video> videoList = wvsi.getVideoByName(vName);
            if (videoList.size() > 0) {
                Video video = videoList.get(0);
                int videoId = video.getVideo_id();
                /*存储播放页面所需的Session值*/
                request.getSession().setAttribute("videosession", videoId);
                request.getSession().setAttribute("sessionListForVideo", videoList);
            }
            JSONArray jAry = JSONArray.fromObject(videoList);
            out.print(jAry);
        } else if (flag.equals("getVideoById")) {
            int videoId = Integer.parseInt(request.getParameter("videoId"));
            Wcg_VideoServiceImpl wvsi = new Wcg_VideoServiceImpl();
            List<Video> list = wvsi.getVideoBId(videoId);
            JSONArray jAry = JSONArray.fromObject(list);
            out.print(jAry);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
