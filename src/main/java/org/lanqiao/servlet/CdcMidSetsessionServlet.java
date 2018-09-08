package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CdcMidSetsessionServlet")
public class CdcMidSetsessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int v_id = Integer.parseInt(request.getParameter("video_id"));
//        System.out.print(v_id + "------------------a");
        request.getSession().setAttribute("videosession",v_id);
        PrintWriter out =response.getWriter();
        out.print(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
