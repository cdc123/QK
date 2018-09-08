package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.entity.User;
import org.lanqiao.serviceImpl.userServiceImpl;
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

@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        String sessionPhone = (String) request.getSession().getAttribute("phone");
        PrintWriter out = response.getWriter();
        if (flag != null && flag != "" && flag.equals("getUserByPhone")) {
            userServiceImpl usi = new userServiceImpl();
            List<User> list = usi.getUserByPhone(sessionPhone);
            System.out.println(list.toString());
            request.getSession().setAttribute("userId", list.get(0).getUser_id());
            request.getSession().setAttribute("sessionListForUser", list);
            out.print(1);
        } else if (flag != null && flag != "" && flag.equals("register")) {
            String phone = request.getParameter("user_phone");
            String pass = request.getParameter("user_password");
            userServiceImpl usi = new userServiceImpl();
            List<User> list = usi.getUserByPhone(phone);
            if (list.size() > 0) {
                /*该手机号已被注册*/
                out.print(-1);
            } else {
                /*该手机号可以注册*/
                /*Session存储注册用户手机号*/
                request.getSession().setAttribute("phone", phone);
                /*插入数据库操作*/
                int ret = usi.addUser(phone, pass);
                out.print(ret);
            }
        } else {
            /*接收前端传入的phone和password*/
            String phone = request.getParameter("user_phone");
            String password = request.getParameter("user_password");
            userServiceImpl usi = new userServiceImpl();
            List<User> list = usi.SearchID(phone);
            if (list.size() > 0) {/*条件成立，说明手机号有对应的用户*/
                /*验证传入的密码是否正确*/
                User user = list.get(0);
                /*获取后端查出的password*/
                String dbpassword = user.getUser_password();
                /*两个密码进行对比*/
                if (password.equals(dbpassword)) {/*条件成立，用户密码正确，登录成功*/
                    /*List<User>转JsonArray*/
                    JsonConfig jsonConfig = new JsonConfig();
                    jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
                    JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
                    /*返回JsonArray给前端页面*/
                    out.print(jsonArray);
                    /*附带操作，存储两个session对象值,一个用户Id，一个是该Id用户在User表的整行记录*/
                    request.getSession().setAttribute("userId", user.getUser_id());
                    request.getSession().setAttribute("sessionListForUser", list);
                }
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
