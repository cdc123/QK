package org.lanqiao.service;

import org.lanqiao.entity.History;

import java.util.List;

public interface HistoryService {
    //插入历史观看时间
    public int cdc_InHistory(int user_id, int video_id, History history);
    //跳到上次观看结束时间
    public List<History> cdc_OutHistory(int user_id, int video_id);
    //wcg
    public List<History> getHistoryByUserId(int user_id);
}
