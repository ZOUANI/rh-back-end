package com.zs.erh.service.imple;

import com.zs.erh.bean.Message;
import com.zs.erh.bean.MessageDetail;
import com.zs.erh.dao.MessageDetailDao;
import com.zs.erh.service.facade.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageDetailServiceImple implements MessageDetailService {
    @Autowired
    private MessageDetailDao messageDetailDao;

    public Optional<MessageDetail> findById(Long id) {
        return messageDetailDao.findById(id);
    }

    public List<MessageDetail> findAll() {
        return messageDetailDao.findAll();
    }

}
