package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.UserDao;
import org.lanqiao.entity.User;

import java.util.List;

public class UserdaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public List<User> showUser() {
        return executeQuery("select * from user");
    }
}
