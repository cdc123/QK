package org.lanqiao.daoImpl;

import org.lanqiao.dao.BaseDao;
import org.lanqiao.dao.ShowMessageDao;
import org.lanqiao.entity.Message;

import java.util.List;

public class ShowMessageDaoImpl extends BaseDao<Message> implements ShowMessageDao {
    @Override
    public List<Message> showMsg(int pageNum, int pageSize) {
        return executeQuery("SELECT * FROM message ORDER BY msg_id DESC LIMIT ?,? ",new Object[]{(pageNum-1)*pageSize,pageSize});
    }

    @Override
    public int getCommentCount() {
        return getRecordCount("SELECT count(*) FROM `message`");
    }

}
