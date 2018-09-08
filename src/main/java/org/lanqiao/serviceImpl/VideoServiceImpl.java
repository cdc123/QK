package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.VideoDaoImpl;
import org.lanqiao.entity.Video;
import org.lanqiao.service.VideoService;

import java.util.ArrayList;
import java.util.List;

public class VideoServiceImpl implements VideoService {
    @Override
    //相关视频
    public List<Video> cdc_rec_findById(int video_id) {
        VideoDaoImpl videoDao = new VideoDaoImpl();
        List<Video> videoList = videoDao.cdc_findById(video_id);
        String video_type = videoList.get(0).getVideo_type();
        List<Video> videoList1 = videoDao.cdc_findByType(video_type);
        return videoList1;
    }
    //wcg
    /*获取以匹配名字开头的视频名字列*/
    public List<String> getVideoFirstByName(String vName) {
        Video video = new Video();
        video.setVideo_name(vName);
        VideoDaoImpl wvdi = new VideoDaoImpl();
        List<Video> videoList = wvdi.getVideoFirstByName(video);
        List<String> sList = new ArrayList<>();
        for (int i = 0; i < videoList.size(); i++) {
            Video v = videoList.get(i);
            sList.add(v.getVideo_name());
        }
        return sList;
    }

    public List<Video> getVideoByName(String vName) {
        return null;
    }

    public List<Video> getVideoBId(int vId) {
        return null;
    }
}
