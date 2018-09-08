package org.lanqiao.servlet;

import org.lanqiao.daoImpl.VideoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/zmm_showplaytimes")
public class zmm_showplaytimes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count1= new VideoDaoImpl().getPlaytimesCount("中国");
        int count2= new VideoDaoImpl().getPlaytimesCount("中国香港");
        int  count3= new VideoDaoImpl().getPlaytimesCount("中国台湾");
        List list = new ArrayList();
        list.add( count1);
        list.add( count2);
        list.add(count3);
        PrintWriter out=response.getWriter();
        out.print(list);;
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
