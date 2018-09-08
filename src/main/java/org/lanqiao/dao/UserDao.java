package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public interface UserDao {
    //zmm
    public int deleteUser(int id);
    public int insertUser(String password, String phone, String power, String name, String sex, String address, String introduce);
    public List<User> showUser(int pageNum, int pageSize);
    public int getCommentCount();
    //wcg
    /*getUserById*/
    public List<User> getUserById(User user);

    /*alterUserNameById*/
    public int updateUserName(User user);

    /*alterUserSexById*/
    public int updateUserSex(User user);

    /*alterUserAddressById*/
    public int updateUserAddress(User user);

    /*alterUserIntroduceById*/
    public int updateUserIntroduce(User user);

    /*alterUserImageById*/
    public int updateUserImage(User user);

    /*小花*/
    public List<User> checkByPhone(User user);//通过手机号查询user表

    public int addUser(User user);

    public List<User> checkUser(User user);

    public List<User> SearchID(User user);
    //dc
    public List<User> cdc_findById(int user_id);
}
