package org.lanqiao.servlet;

import org.lanqiao.daoImpl.TestDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Test1Servlet")
public class Test1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int u_id = Integer.parseInt(request.getParameter("user_id"));
        TestDaoImpl testDao = new TestDaoImpl();
        List<User> list = testDao.TestByID(u_id);
//        System.out.println(list.get(0).getUser_id());
        request.getSession().setAttribute("sessionListForUser",list);
        PrintWriter out =response.getWriter();
        out.print(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
