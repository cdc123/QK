package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.entity.User;
import org.lanqiao.serviceImpl.Wcg_UserServiceImpl;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Wcg_PersonalInfoChange")
public class Wcg_PersonalInfoChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        PrintWriter out = response.getWriter();
        /*获取Session存储值*/
        int user_id = (int) request.getSession().getAttribute("userId");
        /*<测试数据*/
//        int user_id = 20;
        /*测试数据>*/
        if (flag.equals("getUserById")) {
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            List<User> list = wusi.getUserById(user_id);
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonDateValueProcessor());
            /*将List对象转换成jsonArray对象*/
            JSONArray ja = JSONArray.fromObject(list, jsonConfig);
            System.out.println(ja);
            out.print(ja);
        } else if (flag.equals("updateUserName")) {
            String user_name = request.getParameter("userName");
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            int ret = -1;
            ret = wusi.updateUserName(user_id, user_name);
            System.out.println(ret);
            out.print(ret);
        } else if (flag.equals("updateUserSex")) {
            String user_sex = request.getParameter("userSex");
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            int ret = -1;
            ret = wusi.updateUserSex(user_id, user_sex);
            System.out.println(ret);
            out.print(ret);
        } else if (flag.equals("updateUserAddress")) {
            String user_address = request.getParameter("userAddress");
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            int ret = -1;
            ret = wusi.updateUserAddress(user_id, user_address);
            System.out.println(ret);
            out.print(ret);
        } else if (flag.equals("updateUserIntroduce")) {
            String user_introduce = request.getParameter("userIntroduce");
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            int ret = -1;
            ret = wusi.updateUserIntroduce(user_id, user_introduce);
            System.out.println(ret);
            out.print(ret);
        } else if (flag.equals("photoUpload")) {
            String user_image = request.getParameter("userImage");
            Wcg_UserServiceImpl wusi = new Wcg_UserServiceImpl();
            int ret = -1;
            ret = wusi.updateUserImage(user_id, user_image);
            System.out.println(ret);
            out.print(ret);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
