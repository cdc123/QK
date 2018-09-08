package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

import java.util.List;

public class userDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public int deleteUser(int id) {
        return executeUpdate("delete from user where user_id = ?",new Object[]{id});
    }

    @Override
    public int insertUser(String password, String phone, String power, String name, String sex, String address, String introduce) {
        return executeUpdate("insert into user(user_password,user_phone,user_power,user_name,user_sex,user_address,user_introduce) values(?,?,?,?,?,?,?)",new Object[]{password,phone,power,name,sex,address,introduce});
    }

    @Override
    public List<User> showUser(int pageNum, int pageSize) {
        return executeQuery("select * from user order by user_id desc LIMIT ?,? ",new Object[]{(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public int getCommentCount() {
        return getRecordCount("SELECT count(*) FROM user");
    }
    public List<User> getUserById(User user) {
        return null;
    }
    public int updateUserName(User user) {
        return 0;
    }
    public int updateUserSex(User user) {
        return 0;
    }
    public int updateUserAddress(User user) {
        return 0;
    }
    public int updateUserIntroduce(User user) {
        return 0;
    }
    public int updateUserImage(User user) {
        return 0;
    }
    public List<User> checkByPhone(User user) {
        return executeQuery("select * from user where user_phone = '" + user.getUser_phone() + "'");
    }
    public int addUser(User user) {
        return executeUpdate("insert into user(user_phone,user_password) values (?,?)", new Object[]{user.getUser_phone(), user.getUser_password()});
    }
    public List<User> checkUser(User user) {
        return executeQuery("select * from user where user_phone='" + user.getUser_phone() + "'");
    }
    public List<User> SearchID(User user) {
        return executeQuery("select * from user where user_phone='" + user.getUser_phone() + "'");
    }
    //dc
    public List<User> cdc_findById(int user_id){
        List<User> userList = executeQuery("SELECT user_image,user_name FROM user WHERE user_id = ?;", new Object[]{user_id});
        return userList;
    }

}
