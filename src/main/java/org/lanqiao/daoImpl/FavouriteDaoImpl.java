package org.lanqiao.daoImpl;


import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.FavouriteDao;
import org.lanqiao.entity.Favourite;

import java.util.List;

public class FavouriteDaoImpl extends BaseDao<Favourite> implements FavouriteDao {
    @Override
    //添加收藏
    public int cdc_F_docreat(int user_id, int video_id) {
        int i = executeUpdate("INSERT INTO favourite VALUES(?,?);",new Object[]{user_id,video_id});
        return i;
    }
    //判断用户是否有收藏记录
    public List<Favourite> cdc_F_findById(int user_id,int video_id) {
        List<Favourite> favouriteList = executeQuery("SELECT * FROM favourite WHERE user_id = ? AND video_id = ?;",new Object[]{user_id,video_id});
        return favouriteList;
    }
    public List<Favourite> wcg_getFavouriteById(Favourite favourite) {
        return executeQuery("select * from favourite where user_id = " + favourite.getUser_id());
    }
}
