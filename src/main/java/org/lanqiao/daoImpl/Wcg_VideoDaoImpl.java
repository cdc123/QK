package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.VideoDao;
import org.lanqiao.entity.Video;

import java.util.List;

public class Wcg_VideoDaoImpl extends BaseDao<Video> implements VideoDao {

    @Override
    public List<Video> cdc_findById(int video_id) {
        return null;
    }

    @Override
    public List<Video> cdc_findByType(String video_type) {
        return null;
    }

    @Override
    public List<Video> cdc_fingByIdSort(String video_sort) {
        return null;
    }

    @Override
    public List<Video> showVideo(String order, Video video, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int getCount(String order, Video video) {
        return 0;
    }

    @Override
    public List<Video> getIdByVideo_name(String video_name) {
        return null;
    }

    @Override
    public int updateVideo_playtimes(String video_name) {
        return 0;
    }

    @Override
    public List<Video> searchVideo(String video_name) {
        return null;
    }

    @Override
    public int getPlaytimesCount(String region) {
        return 0;
    }

    @Override
    public List<Video> showVideo(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int getCommentCount() {
        return 0;
    }

    @Override
    public int deleteVideo(int id) {
        return 0;
    }

    @Override
    public int updateVideo(String name, String introduce, String sort, String region, String type, int id) {
        return 0;
    }

    /*getVideoFirstByName*/
    @Override
    public List<Video> getVideoFirstByName(Video video) {
        return executeQuery("select * from video where video_name like '" + video.getVideo_name() + "%'");
    }

    /*getVideoByName*/
    @Override
    public List<Video> getVideoByName(Video video) {
        return executeQuery("select * from video where video_name = '" + video.getVideo_name() + "'");
    }

    @Override
    public List<Video> getVideoById(Video video) {
        return executeQuery("select * from video where video_id = " + video.getVideo_id());
    }

    @Override
    public List<Video> SearchVideo(Video video) {
        return null;
    }


}
