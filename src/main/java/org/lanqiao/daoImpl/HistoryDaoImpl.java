package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.HistoryDao;
import org.lanqiao.entity.History;


import java.util.List;

public class HistoryDaoImpl extends BaseDao<History> implements HistoryDao {
    @Override
    //用户第一次观看视频的插入方法
    public int cdc_docreat(int user_id, int video_id,History history) {
        int i = executeUpdate("INSERT INTO history (user_id,video_id,history_holder,history_total) VALUES(?,?,?,?);",new Object[]{user_id,video_id,history.getHistory_holder(),history.getHistory_total()});
        return i;
    }
    //用户不是第一次观看视频的更新
    public int cdc_doupdate(int user_id, int video_id, History history) {
        int j = executeUpdate("UPDATE history SET history_holder = ? ,history_total = ? WHERE user_id = ? AND video_id = ?;",new Object[]{history.getHistory_holder(),history.getHistory_total(),user_id,video_id});
        return j;
    }
    //查询用户是不是第一次看视频
    public List<History> cdc_findById(int user_id,int video_id) {
        List<History> historyList = executeQuery("SELECT * FROM history WHERE user_id = ? AND video_id = ?;",new Object[]{user_id,video_id});
        return historyList;
    }
    //查询用户上次观看结束时间
    public List<History> cdc_findById_holder(int user_id, int video_id) {
        List<History> historyList1 = executeQuery("SELECT history_holder FROM history WHERE user_id = ? AND video_id = ?;",new Object[]{user_id,video_id});
        return historyList1;
    }

    @Override
    public List<History> getHistoryById(History history) {
        return null;
    }

}
