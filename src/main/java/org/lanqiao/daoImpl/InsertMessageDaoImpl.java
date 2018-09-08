package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.InsertMessageDao;
import org.lanqiao.entity.Message;


public class InsertMessageDaoImpl extends BaseDao<Message> implements InsertMessageDao {

    @Override
    public int InsertMsg(int video_id, int user_id, String msg_text) {
//        System.out.println(user_id);
//        System.out.println(video_id);
        return executeUpdate("insert into message (video_id,user_id,msg_text)value(?,?,?)", new Object[]{video_id,user_id,msg_text});
    }
}
