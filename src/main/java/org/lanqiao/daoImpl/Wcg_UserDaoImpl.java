package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

import java.util.List;

public class Wcg_UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public int insertUser(String password, String phone, String power, String name, String sex, String address, String introduce) {
        return 0;
    }

    @Override
    public List<User> showUser(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int getCommentCount() {
        return 0;
    }

    @Override
    public List<User> getUserById(User user) {
        return executeQuery("select * from user where user_id = " + user.getUser_id());
    }

    /*alterUserNameByName*/
    @Override
    public int updateUserName(User user) {
        return executeUpdate("update user set user_name = ? where user_id = ?", new Object[]{user.getUser_name(), user.getUser_id()});
    }

    @Override
    public int updateUserSex(User user) {
        return executeUpdate("update user set user_sex = ? where user_id = ?", new Object[]{user.getUser_sex(), user.getUser_id()});
    }

    @Override
    public int updateUserAddress(User user) {
        return executeUpdate("update user set user_address = ? where user_id = ?", new Object[]{user.getUser_address(), user.getUser_id()});
    }

    @Override
    public int updateUserIntroduce(User user) {
        return executeUpdate("update user set user_introduce = ? where user_id = ?", new Object[]{user.getUser_introduce(), user.getUser_id()});
    }

    @Override
    public int updateUserImage(User user) {
        return executeUpdate("update user set user_image = ? where user_id = ?", new Object[]{user.getUser_image(), user.getUser_id()});
    }

    @Override
    public List<User> checkByPhone(User user) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public List<User> checkUser(User user) {
        return null;
    }

    @Override
    public List<User> SearchID(User user) {
        return null;
    }

    @Override
    public List<User> cdc_findById(int user_id) {
        return null;
    }


}
