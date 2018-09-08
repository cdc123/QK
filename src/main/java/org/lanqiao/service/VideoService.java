package org.lanqiao.service;

import org.lanqiao.entity.Video;

import java.util.List;

public interface VideoService {
    //相关视频
    public List<Video> cdc_rec_findById(int video_id);
    //wcg
    /*获取以匹配字段开头的视频的名字列*/
    public List<String> getVideoFirstByName(String vName);

    /*获取名字和匹配字段相同的视频的id*/
    public List<Video> getVideoByName(String vName);

    public List<Video> getVideoBId(int vId);
}
