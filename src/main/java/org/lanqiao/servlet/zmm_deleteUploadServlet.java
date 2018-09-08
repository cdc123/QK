package org.lanqiao.servlet;

import org.lanqiao.daoImpl.UploadVideoDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/zmm_deleteUploadServlet")
public class zmm_deleteUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        int id2=Integer.parseInt(id);
        int ret=new UploadVideoDaoImpl().deleteUpload(id2);
        PrintWriter out = response.getWriter();
        out.print(ret);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
