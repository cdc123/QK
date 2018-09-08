package org.lanqiao.serviceImpl;

import org.lanqiao.daoImpl.HistoryDaoImpl;
import org.lanqiao.entity.History;
import org.lanqiao.service.HistoryService;

import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    @Override
    //插入历史观看时间
    public int cdc_InHistory(int user_id, int video_id, History history) {
        HistoryDaoImpl historyDao = new HistoryDaoImpl();
        List<History> list1 = historyDao.cdc_findById(user_id,video_id);
        int i;
        //        判断表里是否有记录
        if (list1.size()>0) {
            i = historyDao.cdc_doupdate(user_id, video_id, history);
        } else {
            i = historyDao.cdc_docreat(user_id, video_id, history);
        }
        return i;
    }

    public List<History> cdc_OutHistory(int user_id, int video_id) {
        HistoryDaoImpl historyDao = new HistoryDaoImpl();
        
        List<History> list1 = historyDao.cdc_findById(user_id,video_id);
        List<History> list2 = null;
//        判断表里是否有记录
        if (list1.size()>0) {
          list2 = historyDao.cdc_findById_holder(user_id, video_id);
        } else {
            //给holder对象赋值
            list2 = historyDao.cdc_findById_holder(user_id, video_id);
            list2.get(0).setHistory_holder(0);
        }
        return list2;
    }

    @Override
    public List<History> getHistoryByUserId(int user_id) {
        return null;
    }
}
