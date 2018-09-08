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

@WebServlet("/YfShowVideoServlet")
public class YfShowVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从html得到数据
        String sort = request.getParameter("sort");
        String region = request.getParameter("region");
        String type = request.getParameter("type");
        String order = request.getParameter("order");
        String num = request.getParameter("num");


        int pageNum = 0;
        if(num != null && !num.equals("")){
            pageNum = Integer.parseInt(num);
        }
        //封装数据
        Video video = new Video(sort,region,type);
        //调用dao
        VideoDaoImpl showVideo = new VideoDaoImpl();
        List<Video> videoList = showVideo.showVideo(order,video,pageNum,5);
        JSONArray jsonArray = JSONArray.fromObject(videoList);
        //添加查询数
        jsonArray.add(showVideo.getCount(order,video));
        //传给html
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }
}
