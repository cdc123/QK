package org.lanqiao.dao;

import org.lanqiao.entity.History;

import java.util.List;

public interface HistoryDao {
    //用户第一次观看视频的插入方法
    public int cdc_docreat(int user_id,int video_id,History history);
    //用户不是第一次观看视频的更新
    public int cdc_doupdate(int user_id,int video_id,History history);
    //查询用户是不是第一次看视频
    public List<History> cdc_findById(int user_id,int video_id);
    //查询用户上次观看结束时间
    public List<History> cdc_findById_holder(int user_id,int video_id);
    //wcg
    public List<History> getHistoryById(History history);
}

