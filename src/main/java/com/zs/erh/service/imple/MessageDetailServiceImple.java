package com.zs.erh.service.imple;

import com.zs.erh.bean.MessageDetail;
import com.zs.erh.dao.MessageDetailDao;
import com.zs.erh.service.facade.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageDetailServiceImple implements MessageDetailService {
    @Autowired
    private MessageDetailDao messageDetailDao;

    public List<MessageDetail> findByMessageId(Long id) {
        return messageDetailDao.findByMessageId(id);
    }

    public List<MessageDetail> findAll() {
        return messageDetailDao.findAll();
    }

	@Override
	public int save(MessageDetail messageDetail) {
		if (messageDetail != null) {
			 messageDetailDao.save(messageDetail);
			 return 1;
		}
		else {
			 return -1;
		}
		
	}

}
