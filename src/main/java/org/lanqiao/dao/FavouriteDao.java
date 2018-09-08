package org.lanqiao.dao;

import org.lanqiao.entity.Favourite;

import java.util.List;

public interface FavouriteDao {
    //添加收藏
    public int cdc_F_docreat(int user_id,int video_id);
    //判断用户是否有收藏记录
    public List<Favourite> cdc_F_findById(int user_id,int video_id);

    public List<Favourite> wcg_getFavouriteById(Favourite favourite);
}
