package com.zs.erh.service.imple;


import com.zs.erh.bean.*;
import com.zs.erh.dao.MessageDao;
import com.zs.erh.dao.MessageDetailDao;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.DemandeCongeVo;
import com.zs.erh.service.vo.MessageVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

@Service
public class MessageServiceImple extends AbstractFacade<Message>  implements MessageService {
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
    @Autowired
    private EntityManager entityManager;

    public List<Message> findBySourceLogin(String login) {
        return messageDao.findBySourceLogin(login);
    }

    public Optional<Message> findById(Long id) {
        return messageDao.findById(id);
    }

    public List<Message> findAll() {
        return messageDao.findAll();
    }
    
	public List<Message> findByEtatMessageCode(String code) {
		return messageDao.findByEtatMessageCode(code);
	}
	
	

    public Message save(Message message) {
        EtatMessage etatMessage = etatMessageService.findByCode(message.getEtatMessage().getCode());
        message.setEtatMessage(etatMessage);
        message.setDateEnvoi(new Date());   
        User source = userService.findByLogin(message.getSource().getLogin()).get();
    	message.setSource(source);

        if(etatMessage == null || source == null){
            System.out.println(etatMessage);
            System.out.println(source);
            return null;
        }else{
            
            messageDao.save(message);
            for (MessageDetail  messageDetail : message.getMessageDetails()){
                System.out.println(messageDetail.getLoginDestinataire());
                
                if(messageDetail!=null && messageDetail.getDistinataire()!=null) {
                	 messageDetail.setMessage(message);
                     messageDetail.setDistinataire(userService.findByLogin(messageDetail.getLoginDestinataire()).get());
                     messageDetail.setEtatMessage(etatMessage);
                     System.out.println(messageDetail.getDistinataire().getLogin());
                     messageDetailService.save(messageDetail);
                     

                }else {
                	System.out.println("index i is null :: ");
                }
               
            }
            return message;
        }

    }
    
	@Override
	public Message saveMD(Message message, List<MessageDetail> messageDetails) {
		EtatMessage etatMessage = etatMessageService.findByCode(message.getEtatMessage().getCode());
        message.setEtatMessage(etatMessage);
        message.setDateEnvoi(new Date());   
        User source = userService.findByLogin(message.getSource().getLogin()).get();
    	message.setSource(source);
		if(etatMessage == null || source == null)
			return null;
		
		else {
			 messageDao.save(message);
			for (MessageDetail  messageDetail : messageDetails) {
				messageDetail.setMessage(message);
	            messageDetail.setDistinataire(userService.findByLogin(messageDetail.getLoginDestinataire()).get());
	            messageDetail.setEtatMessage(etatMessage);
	          
	            messageDetailService.save(messageDetail);
			}

			return message;
		}
		
	}




    public List<Message> searchMessage(MessageVO messageVO) {
        String query = "SELECT m FROM Message m where 1=1";
        if (messageVO.getEtatMessageId() != null) {
            query += " AND m.etatMessage.id= " +messageVO.getEtatMessageId();
        }
        query += addConstraintMinMaxDate("m", "dateEnvoi", messageVO.getDateMin(), messageVO.getDateMax());

        return entityManager.createQuery(query).getResultList();
    }

	@Override
	public Message update(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageVO> findByMassageDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<Message> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
