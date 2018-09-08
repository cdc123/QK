package org.lanqiao.dao;

import org.lanqiao.entity.Message;

import java.util.List;

public interface MessageDao {
    //zmm
    public List<Message> showMsg(int pageNum, int pageSize);
    public int deleteVideo(int id);
    public int getCommentCount();
}
