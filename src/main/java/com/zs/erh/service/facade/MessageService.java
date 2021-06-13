package com.zs.erh.service.facade;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> findBySourceCode(String code);
    Optional<Message> findById(Long id);
    List<Message> findAll();
    Message save(Message message);
}
