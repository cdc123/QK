package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.daoImpl.userDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CdcGetphotoServlet")
public class CdcGetphotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int u_id = Integer.parseInt(request.getParameter("user_id"));
        userDaoImpl userDao = new userDaoImpl();
        List<User> list =  userDao.cdc_findById(u_id);
        PrintWriter out =response.getWriter();
        out.print(JSONArray.fromObject(list));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
