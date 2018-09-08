package org.lanqiao.servlet;

import org.lanqiao.daoImpl.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/zmm_insertUserServlet")
public class zmm_insertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String power = request.getParameter("power");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String birthday1 = request.getParameter("birthday1");
        String introduce = request.getParameter("introduce");
        int ret = new userDaoImpl().insertUser(password, phone, power, name, sex, address, introduce);
        PrintWriter out = response.getWriter();
        out.print(ret);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
