package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao{
    @Override
    public List<User> findById() {
        List<User> userList = executeQuery("select * from user");
        return userList;
    }

}
