package org.lanqiao.dao;


import org.lanqiao.entity.Message;

import java.util.List;

public interface ShowMessageDao {
    public List<Message> showMsg(int pageNum, int pageSize);
    int getCommentCount();
}
