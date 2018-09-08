package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.HistoryDao;
import org.lanqiao.entity.History;

import java.util.List;

public class Wcg_HistoryDaoImpl extends BaseDao<History> implements HistoryDao {

    @Override
    public int cdc_docreat(int user_id, int video_id, History history) {
        return 0;
    }

    @Override
    public int cdc_doupdate(int user_id, int video_id, History history) {
        return 0;
    }

    @Override
    public List<History> cdc_findById(int user_id, int video_id) {
        return null;
    }

    @Override
    public List<History> cdc_findById_holder(int user_id, int video_id) {
        return null;
    }

    @Override
    public List<History> getHistoryById(History history) {
        return executeQuery("select user_id,video_id,history_time,history_holder,history_total from history where user_id = " + history.getUser_id() + " order by history_time asc");
    }
}
