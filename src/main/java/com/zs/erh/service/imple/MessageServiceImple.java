package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.EtatDemandeConge;
import com.zs.erh.bean.EtatMessage;
import com.zs.erh.bean.Message;
import com.zs.erh.dao.MessageDao;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.EtatMessageService;
import com.zs.erh.service.facade.MessageDetailService;
import com.zs.erh.service.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImple  implements MessageService {
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private EtatMessageService etatMessageService;
    @Autowired
    private MessageDetailService messageDetailService;

    public List<Message> findBySourceCode(String code) {
        return messageDao.findBySourceCode(code);
    }

    public Optional<Message> findById(Long id) {
        return messageDao.findById(id);
    }

    public List<Message> findAll() {
        return messageDao.findAll();
    }

    public Message save(Message message) {
        EtatMessage etatMessage = etatMessageService.findByCode(message.getEtatMessage().getCode());
        Collaborateur source = collaborateurService.findByCode(message.getSource().getCode());
        if(etatMessage == null || source == null){
            return null;
        }else{
            messageDetailService.save(message, message.getMessageDetails());
            messageDao.save(message);
            return message;
        }

    }
}
