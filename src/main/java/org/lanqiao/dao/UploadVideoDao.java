package org.lanqiao.dao;

import org.lanqiao.entity.UploadVideo;

import java.util.List;

public interface UploadVideoDao {
    //zmm
    public List<UploadVideo> showUploadVideo();
    public int deleteUpload(int id);
}
