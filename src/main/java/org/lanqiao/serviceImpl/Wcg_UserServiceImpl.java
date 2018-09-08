package org.lanqiao.serviceImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.daoImpl.Wcg_UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

import java.util.List;

public class Wcg_UserServiceImpl extends BaseDao<User> implements UserService {

    @Override
    public List<User> getUserById(int user_id) {
        User user = new User();
        user.setUser_id(user_id);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        List<User> list = wudi.getUserById(user);
        return list;
    }

    @Override
    public int updateUserName(int user_id, String user_name) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_name(user_name);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        return wudi.updateUserName(user);

    }

    @Override
    public int updateUserSex(int user_id, String user_sex) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_sex(user_sex);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        return wudi.updateUserSex(user);
    }

    @Override
    public int updateUserAddress(int user_id, String user_address) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_address(user_address);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        return wudi.updateUserAddress(user);
    }

    @Override
    public int updateUserIntroduce(int user_id, String user_introduce) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_introduce(user_introduce);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        return wudi.updateUserIntroduce(user);
    }

    @Override
    public int updateUserImage(int user_id, String user_image) {
        User user = new User();
        user.setUser_id(user_id);
        user.setUser_image(user_image);
        Wcg_UserDaoImpl wudi = new Wcg_UserDaoImpl();
        return wudi.updateUserImage(user);
    }

    @Override
    public boolean checkByPhone(String phone) {
        return false;
    }

    @Override
    public List<User> checkUser(String phone, String password) {
        return null;
    }

    @Override
    public int addUser(String phone, String pwd) {
        return 0;
    }

    @Override
    public List<User> SearchID(String phone) {
        return null;
    }

    @Override
    public List<User> getUserByPhone(String phone) {
        return null;
    }


}
