package org.lanqiao.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( "/zmm_GetSeesionServlet")
public class zmm_GetSeesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("userBean");
        String id  = (String) request.getSession().getAttribute(key);
        PrintWriter out = response.getWriter();
        if(!("").equals(key)){
//            JSONObject retUser = JSONObject.fromObject(id);
            out.write(id);
        } else {
            out.write("nologin");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
