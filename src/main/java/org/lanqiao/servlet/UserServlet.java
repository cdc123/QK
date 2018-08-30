package org.lanqiao.servlet;


import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.UserdaoImpl;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserdaoImpl userdao=new UserdaoImpl();
        List<User> list1=userdao.showUser();
        System.out.println(list1);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        JSONArray list = JSONArray.fromObject(list1,jsonConfig);
        System.out.println(list);
        PrintWriter out=response.getWriter();
        out.print(list);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
