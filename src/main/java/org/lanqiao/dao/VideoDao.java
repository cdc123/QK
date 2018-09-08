package org.lanqiao.dao;

import org.lanqiao.entity.Video;

import java.util.List;

public interface VideoDao {
    //dc
    //通过id查询视频所有信息
    public List<Video> cdc_findById(int video_id);
    //通过类型查询视频所有信息
    public List<Video> cdc_findByType(String video_type);
    //通过sort查询视频所有信息
    public  List<Video> cdc_fingByIdSort(String video_sort);
    //yf
    //按分类、地区、类型分类 + 最多播放、最多评论排序 + 分页
    List<Video> showVideo(String order,Video video,int pageNum,int pageSize);
    //查询每次点击事件后的返回条数
    int getCount(String order,Video video);
    //点击影片获取id传给session
    List<Video> getIdByVideo_name(String video_name);
    //播放量
    int updateVideo_playtimes(String video_name);
    //搜索框
    List<Video> searchVideo(String video_name);
    //zmm
    public int getPlaytimesCount(String region);
    public List<Video> showVideo(int pageNum, int pageSize);
    public int getCommentCount();
    public int deleteVideo(int id);
    public int updateVideo(String name, String introduce, String sort, String region, String type, int id);
    //wcg
    /*getVideoFirstByName*/
    public List<Video> getVideoFirstByName(Video video);

    /*getVideoByName*/
    public List<Video> getVideoByName(Video video);

    /*getVideoById*/
    public List<Video> getVideoById(Video video);

    public List<Video> SearchVideo(Video video);
}
