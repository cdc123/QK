package org.lanqiao.dao;

import org.lanqiao.entity.Video;

import java.util.List;

public interface showvideoDao {
    public List<Video> showVideoType(int id);
    public List<Video> showVideo(String type);
}
