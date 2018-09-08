package org.lanqiao.servlet;

import org.lanqiao.serviceImpl.FavuoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CdcShowFavouriteServlet")
public class CdcShowFavouriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int v_id = Integer.parseInt(request.getParameter("video_id"));
        int u_id = Integer.parseInt(request.getParameter("user_id"));
        //dao
        FavuoriteServiceImpl retFavuorite = new FavuoriteServiceImpl();
        int i = retFavuorite.cdc_ShowFavourite(u_id,v_id);
        //out
        PrintWriter out =response.getWriter();
        out.print(i+"");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
