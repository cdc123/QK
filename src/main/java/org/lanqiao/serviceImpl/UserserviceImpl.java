package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.userDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

import java.util.List;

public class userServiceImpl implements UserService {
    @Override
    public List<User> getUserById(int user_id) {
        return null;
    }

    @Override
    public int updateUserName(int user_id, String user_name) {
        return 0;
    }

    @Override
    public int updateUserSex(int user_id, String user_sex) {
        return 0;
    }

    @Override
    public int updateUserAddress(int user_id, String user_address) {
        return 0;
    }

    @Override
    public int updateUserIntroduce(int user_id, String user_introduce) {
        return 0;
    }

    @Override
    public int updateUserImage(int user_id, String user_image) {
        return 0;
    }

    @Override
    public boolean checkByPhone(String phone) {
        /*封装传入参数为对象*/
        User user = new User(phone);
        /*调用dao层方法*/
        userDaoImpl udi = new userDaoImpl();
        List<User> list = udi.checkByPhone(user);
        /*判断返回值list是否为空*/
        if (list.size() > 0) {/*存在手机用户*/
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> checkUser(String phone, String password) {
        User user = new User(phone, password);
        userDaoImpl udi = new userDaoImpl();
//     return Map<String,Objects>  map = udi.checkUser(user);
        return null;
    }

    @Override
    public int addUser(String phone, String pwd) {
        User user = new User(phone, pwd);
        userDaoImpl udi = new userDaoImpl();
        int ret = udi.addUser(user);
        return ret;
    }

    @Override
    public List<User> SearchID(String phone) {
        User user = new User(phone);
        userDaoImpl udi = new userDaoImpl();
        List<User> list = udi.SearchID(user);
        return list;
    }

    @Override
    public List<User> getUserByPhone(String phone) {
        User user = new User(phone);
        userDaoImpl udi = new userDaoImpl();
        List<User> list = udi.SearchID(user);
        return list;
    }
}