package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.MessageDao;
import com.zs.erh.dao.MessageDetailDao;
import com.zs.erh.service.facade.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImple  implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private MessageDetailDao messageDetailDao;
    @Autowired
    private UserService userService;
    @Autowired
    private EtatMessageService etatMessageService;
    @Autowired
    private MessageDetailService messageDetailService;

    public List<Message> findBySourceLogin(String login) {
        return messageDao.findBySourceLogin(login);
    }

    public Optional<Message> findById(Long id) {
        return messageDao.findById(id);
    }

    public List<Message> findAll() {
        return messageDao.findAll();
    }

    public Message save(Message message) {
        EtatMessage etatMessage = etatMessageService.findByCode("e2");
        User source = userService.findByLogin(message.getSource().getLogin()).get();
        if(etatMessage == null || source == null){
            System.out.println(etatMessage);
            System.out.println(source);
            return null;
        }else{
            MessageDetail messageDetail = new MessageDetail();
            message.setDateEnvoi(new Date());
            message.setSource(source);
            message.setEtatMessage(etatMessage);
            messageDao.save(message);
            System.out.println(message.getMessageDetails());
            for (int i=0; i<message.getMessageDetails().toArray().length;i++){
                messageDetail = message.getMessageDetails().get(i);
                System.out.println(messageDetail);
                messageDetail.setMessage(message);
                messageDetail.setDistinataire(userService.findByLogin(messageDetail.getDistinataire().getLogin()).get());
                messageDetail.setEtatMessage(etatMessage);
                messageDetailDao.save(messageDetail);
            }
            return message;
        }

    }
}
