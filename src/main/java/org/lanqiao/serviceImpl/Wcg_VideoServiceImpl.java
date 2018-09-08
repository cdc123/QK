package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.Wcg_VideoDaoImpl;
import org.lanqiao.entity.Video;
import org.lanqiao.service.VideoService;

import java.util.ArrayList;
import java.util.List;

public class Wcg_VideoServiceImpl implements VideoService {

    @Override
    public List<Video> cdc_rec_findById(int video_id) {
        return null;
    }

    /*获取以匹配名字开头的视频名字列*/
    @Override
    public List<String> getVideoFirstByName(String vName) {
        Video video = new Video(vName);
        Wcg_VideoDaoImpl wvdi = new Wcg_VideoDaoImpl();
        List<Video> videoList = wvdi.getVideoFirstByName(video);
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < videoList.size(); i++) {
            Video v = videoList.get(i);
            sList.add(v.getVideo_name());
        }
        return sList;
    }

    /*获取名字和匹配字段相同的视频的id*/
    @Override
    public List<Video> getVideoByName(String vName) {
        Video video = new Video(vName);
        Wcg_VideoDaoImpl wvdi = new Wcg_VideoDaoImpl();
        return wvdi.getVideoByName(video);
    }

    /*根据视频Id查询出视频Name*/
    @Override
    public List<Video> getVideoBId(int vId) {
        Video video = new Video();
        video.setVideo_id(vId);
        Wcg_VideoDaoImpl wvdi = new Wcg_VideoDaoImpl();
        return wvdi.getVideoById(video);
    }

}
