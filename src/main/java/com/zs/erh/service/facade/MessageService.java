package com.zs.erh.service.facade;

import com.zs.erh.bean.Message;
import com.zs.erh.bean.MessageDetail;
import com.zs.erh.service.vo.MessageVO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MessageService {
	
    List<Message> findBySourceLogin(String login);
    
    Optional<Message> findById(Long id);
    
    public List<Message> findByEtatMessageCode(String code);
    
    List<Message> findAll();
    
    Message update(Message message);
    
    Message save(Message message);

    List<Message> searchMessage(MessageVO messageVO);
    
    public List<MessageVO> findByMassageDate( Date date);

	Message saveMD(Message message, List<MessageDetail> messageDetails);
}
