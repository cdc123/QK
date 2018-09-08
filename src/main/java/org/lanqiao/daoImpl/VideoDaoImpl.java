package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.VideoDao;
import org.lanqiao.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoDaoImpl extends BaseDao<Video> implements VideoDao {
    @Override
    //dc
    //通过id查询视频所有信息
    public List<Video> cdc_findById(int video_id) {
        List<Video> videoList = executeQuery("select * from video where video_id = ?",new Object[]{video_id});
        return videoList;
    }
    //通过类型查询视频所有信息
    public List<Video> cdc_findByType(String video_type) {
        List<Video> videoList1 = executeQuery("SELECT * FROM video WHERE video_type = ? limit 5,5;",new Object[]{video_type});
        return videoList1;
    }
    //通过sort查询视频所有信息
    public  List<Video> cdc_fingByIdSort(String video_sort){
        List<Video> videoList2 = executeQuery("SELECT * FROM video WHERE video_sort = ?;",new Object[]{video_sort});
        return videoList2;
    }
    //yf
    public List<Video> searchVideo(String video_name) {
        return executeQuery("select * from video where video_name like '%"+video_name+"%'");
    }
    public int updateVideo_playtimes(String video_name) {
        return executeUpdate("update video set video_playtimes = video_playtimes+1 where video_name = ?",new Object[]{video_name});
    }
    public List<Video> getIdByVideo_name(String video_name) {
        return executeQuery("select * from video where video_name = ?",new Object[]{video_name});
    }
    public int getCount(String order, Video video) {
        String sql = "select * from video where 1=1";
        //List<Object> list = new ArrayList<>();
        if(video.getVideo_sort()!=null && !video.getVideo_sort().equals("")){
            if(video.getVideo_sort().equals("全部")){

            }else{
                sql +=" and video_sort = "+"'"+video.getVideo_sort()+"'";
                //list.add(video.getVideo_sort());
            }
        }
        if(video.getVideo_region()!=null && !video.getVideo_region().equals("")){
            if(video.getVideo_region().equals("全部")){

            }else{
                sql+=" and video_region = "+"'"+video.getVideo_region()+"'";
                // list.add(video.getVideo_region());
            }
        }
        if(video.getVideo_type()!=null && !video.getVideo_type().equals("")){
            if(video.getVideo_type().equals("全部")){

            }else{
                sql+=" and video_type = "+"'"+video.getVideo_type()+"'";
                // list.add(video.getVideo_type());
            }
        }
        if(order!=null && !order.equals("")){
            if(order.equals("最多评论")){
                sql+=" order by video_commentnum desc";
            }else {
                sql+=" order by video_playtimes desc";
            }
        }
        sql = "select count(*) from ("+sql+") as video_list";
        return getRecordCount(sql);
    }
    public List<Video> showVideo(String order,Video video,int pageNum,int pageSize) {
        String sql = "select * from video where 1=1";
        List<Object> list = new ArrayList<>();
        if(video.getVideo_sort()!=null && !video.getVideo_sort().equals("")){
            if(video.getVideo_sort().equals("全部")){

            }else{
                sql +=" and video_sort = ?";
                list.add(video.getVideo_sort());
            }
        }
        if(video.getVideo_region()!=null && !video.getVideo_region().equals("")){
            if(video.getVideo_region().equals("全部")){

            }else{
                sql+=" and video_region = ?";
                list.add(video.getVideo_region());
            }
        }
        if(video.getVideo_type()!=null && !video.getVideo_type().equals("")){
            if(video.getVideo_type().equals("全部")){

            }else{
                sql+=" and video_type = ?";
                list.add(video.getVideo_type());
            }
        }
        if(order!=null && !order.equals("")){
            if(order.equals("最多评论")){
                sql+=" order by video_commentnum desc";
            }else {
                sql+=" order by video_playtimes desc";
            }
        }
        sql += " limit ?,?";
        int start = (pageNum-1)*pageSize;
        list.add(start);
        list.add(pageSize);
        Object obj[] = list.toArray();
        return executeQuery(sql,obj);
    }
    //zmm
    public List<Video> showVideo(int pageNum, int pageSize) {
        return executeQuery("SELECT * FROM video LIMIT ?,? ",new Object[]{(pageNum-1)*pageSize,pageSize});
    }
    public int getCommentCount() {
        return getRecordCount("SELECT count(*) FROM video");
    }
    public int getPlaytimesCount(String region) {
        return getCount("select sum(video_playtimes) from video where video_region=?", new Object[]{region});
    }
    public int deleteVideo(int id) {
        return executeUpdate("delete from video where video_id = ?", new Object[]{id});
    }

    public int updateVideo(String name, String introduce, String sort, String region, String type, int id) {
        return executeUpdate("update video set video_name = ?,video_introduce= ?,video_sort=?,video_region=?,video_type=? WHERE video_id = ?", new Object[]{name, introduce, sort, region, type, id});
    }
    //wcg
    public List<Video> SearchVideo(Video video) {
        return executeQuery("select * from video where video_name like  '" + video.getVideo_name() + "'%");
    }

    public List<Video> getVideoFirstByName(Video video) {
        return executeQuery("select * from video where video_name like '" + video.getVideo_name() + "%'");
    }
    public List<Video> getVideoByName(Video video) {
        return null;
    }
    public List<Video> getVideoById(Video video) {
        return null;
    }
}
