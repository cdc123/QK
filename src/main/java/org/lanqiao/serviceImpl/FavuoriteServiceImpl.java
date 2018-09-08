package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.FavouriteDaoImpl;
import org.lanqiao.daoImpl.Wcg_VideoDaoImpl;
import org.lanqiao.entity.Favourite;
import org.lanqiao.entity.Video;
import org.lanqiao.service.FavouriteService;

import java.util.ArrayList;
import java.util.List;

public class FavuoriteServiceImpl implements FavouriteService {
    @Override
    //第一次收藏
    public int cdc_Favourite(int user_id, int video_id) {
        FavouriteDaoImpl favoriteDao = new FavouriteDaoImpl();
        List<Favourite> list1 = favoriteDao.cdc_F_findById(user_id,video_id);
        int i = 0;
        //        判断表里是否有记录
        if (list1.size()>0) {

        } else {
            i = favoriteDao.cdc_F_docreat(user_id, video_id);
        }
        return i;

    }
    //显示收藏
    public int cdc_ShowFavourite(int user_id, int video_id) {
//        int k = -1;
        FavouriteDaoImpl favoriteDao = new FavouriteDaoImpl();
        List<Favourite> list1 = favoriteDao.cdc_F_findById(user_id,video_id);
        //判断集合是否为空
//        if (list1 != null && !list1.isEmpty()) {
//            k = list1.get(0).getVideo_id();
//        }
        int i = 0;
        //        判断表里是否有记录
        if (list1.size()>0) {

        } else {
            i = -1;
        }
        return i;
    }
    public List<Video> wcg_getFavouriteById(int user_id) {
        Favourite favourite = new Favourite();
        favourite.setUser_id(user_id);
        FavouriteDaoImpl fdi = new FavouriteDaoImpl();
        List<Favourite> favouriteList = fdi.wcg_getFavouriteById(favourite);
        List<Video> list = new ArrayList<>();
        for (int i = 0; i < favouriteList.size(); i++) {
            int video_id = favouriteList.get(i).getVideo_id();
            Video video = new Video();
            video.setVideo_id(video_id);
            Wcg_VideoDaoImpl wvdi = new Wcg_VideoDaoImpl();
            List<Video> videoList = wvdi.getVideoById(video);
            Video video1 = videoList.get(0);
            list.add(video1);
        }
        return list;
    }
}
