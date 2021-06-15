package com.zs.erh.service.facade;

import com.zs.erh.bean.Message;
import com.zs.erh.bean.MessageDetail;

import java.util.List;
import java.util.Optional;

public interface MessageDetailService {
    Optional<MessageDetail> findById(Long id);
    List<MessageDetail> findAll();
}
