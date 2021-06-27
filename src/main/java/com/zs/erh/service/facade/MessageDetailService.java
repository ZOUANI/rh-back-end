package com.zs.erh.service.facade;

import com.zs.erh.bean.MessageDetail;

import java.util.List;

public interface MessageDetailService {
    List<MessageDetail> findByMessageId(Long id);
    List<MessageDetail> findAll();
    int save(MessageDetail messageDetail);
}
