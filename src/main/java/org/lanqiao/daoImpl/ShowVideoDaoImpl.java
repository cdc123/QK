package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.showvideoDao;
import org.lanqiao.entity.Video;

import java.util.List;

public class ShowVideoDaoImpl extends BaseDao<Video> implements showvideoDao {
public List<Video> showVideoType(int id) {
        return executeQuery("select video_type from video where video_id = ?",new Object[]{id});
        }
public List<Video> showVideo(String type) {
        return executeQuery("select video_playtimes,video_image,video_introduce,video_name from video where video_type = ?",new Object[]{type});
        }
}
