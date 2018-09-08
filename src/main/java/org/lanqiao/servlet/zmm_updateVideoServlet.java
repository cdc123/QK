package org.lanqiao.servlet;

import org.lanqiao.daoImpl.VideoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/zmm_updateVideoServlet")
public class zmm_updateVideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String introduce=request.getParameter("introduce");
        String sort=request.getParameter("sort");
        String region=request.getParameter("region");
        String type=request.getParameter("type");
        String id=request.getParameter("id");
        int id2=Integer.parseInt(id);
        int ret=new VideoDaoImpl().updateVideo(name,introduce,sort,region,type,id2);
        PrintWriter out  =  response.getWriter();
        out.print(ret);
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
