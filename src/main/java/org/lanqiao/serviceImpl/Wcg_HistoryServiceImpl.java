package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.Wcg_HistoryDaoImpl;
import org.lanqiao.entity.History;
import org.lanqiao.service.HistoryService;

import java.util.List;

public class Wcg_HistoryServiceImpl implements HistoryService {

    @Override
    public int cdc_InHistory(int user_id, int video_id, History history) {
        return 0;
    }

    @Override
    public List<History> cdc_OutHistory(int user_id, int video_id) {
        return null;
    }

    @Override
    public List<History> getHistoryByUserId(int user_id) {
        History history = new History();
        history.setUser_id(user_id);
        Wcg_HistoryDaoImpl hdi = new Wcg_HistoryDaoImpl();
        return hdi.getHistoryById(history);
    }
}
