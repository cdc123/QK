package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.MessageDao;
import org.lanqiao.entity.Message;

import java.util.List;

public class MessageDaoImpl extends BaseDao<Message> implements MessageDao {

//    public List<Message> showMessage() {
//        return executeQuery("select * from message");
//    }

    @Override
    //zmm
    public int deleteVideo(int id) {
        return executeUpdate("delete from message where msg_id = ?",new Object[]{id});
    }
    public List<Message> showMsg(int pageNum, int pageSize) {
        return executeQuery("SELECT * FROM message LIMIT ?,? ",new Object[]{(pageNum-1)*pageSize,pageSize});
    }
    public int getCommentCount() {
       return getRecordCount("SELECT count(*) FROM message");
    }


}
