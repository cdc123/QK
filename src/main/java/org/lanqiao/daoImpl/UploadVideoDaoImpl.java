package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.UploadVideoDao;
import org.lanqiao.entity.UploadVideo;

import java.util.List;

public class UploadVideoDaoImpl extends BaseDao<UploadVideo> implements UploadVideoDao {
    @Override
    //zmm
    public List<UploadVideo> showUploadVideo() {
        return executeQuery("select * from upload_video");
        }
    public int deleteUpload(int id) {
        return executeUpdate("delete from upload_video where upv_id = ?",new Object[]{id});
    }
}