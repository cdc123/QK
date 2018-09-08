package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.entity.User;

import java.util.List;

public class TestDaoImpl extends BaseDao<User> {
    public List<User> TestByID(int user_id){
        List<User> userList = executeQuery("SELECT user_id,user_name FROM user WHERE user_id = ?;",new Object[]{user_id});
        return userList;
    };
}
