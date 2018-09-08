package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.serviceImpl.VideoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/SearchVideoNameServlet")
public class SearchVideoNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String vName = request.getParameter("video_name");
        VideoServiceImpl wvsi = new VideoServiceImpl();
        List<String> al = wvsi.getVideoFirstByName(vName);
        JSONArray jAry = JSONArray.fromObject(al);
        out.print(jAry);
        }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
