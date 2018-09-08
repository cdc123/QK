package org.lanqiao.service;

import org.lanqiao.entity.User;

import java.util.List;

public interface UserService {

    /*Gordon*/
    public List<User> getUserById(int user_id);

    public int updateUserName(int user_id, String user_name);

    public int updateUserSex(int user_id, String user_sex);

    public int updateUserAddress(int user_id, String user_address);

    public int updateUserIntroduce(int user_id, String user_introduce);

    public int updateUserImage(int user_id, String user_image);

    /*小花*/
    public boolean checkByPhone(String phone);//判断是否存在此手机用户 返回boolean类型

    public List<User> checkUser(String phone, String password);//判断是否存在  返回List类型

    public int addUser(String phone, String pwd);//添加手机用户

    public List<User> SearchID(String phone);

    public List<User> getUserByPhone(String phone);

}
