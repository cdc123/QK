package org.lanqiao.service;

import org.lanqiao.entity.Video;

import java.util.List;

public interface FavouriteService {
    //第一次收藏
    public int cdc_Favourite(int user_id,int video_id);
    //显示收藏
    public int cdc_ShowFavourite(int user_id,int video_id);
    public List<Video> wcg_getFavouriteById(int user_id);
}
