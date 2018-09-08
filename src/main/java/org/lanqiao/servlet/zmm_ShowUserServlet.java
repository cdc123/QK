package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.daoImpl.userDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.util.user_JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/zmm_ShowUserServlet")
public class zmm_ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenumber = request.getParameter("pagenumber");
        int pnumber = Integer.parseInt(pagenumber);
        userDaoImpl userdaoimpl = new userDaoImpl();
        //查询分页数据
        List<User> list = userdaoimpl.showUser(pnumber,8);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new user_JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        int rsCount = userdaoimpl.getCommentCount();
        jsonArray.add(rsCount);
//        System.out.println(rsCount);
        //json发送到前端
        PrintWriter out = response.getWriter();
        out.print(jsonArray);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
