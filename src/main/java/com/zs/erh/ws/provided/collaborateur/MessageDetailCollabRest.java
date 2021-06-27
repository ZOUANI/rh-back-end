package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.MessageDetail;
import com.zs.erh.service.facade.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/message-detail")
public class MessageDetailCollabRest {
    @Autowired
    private MessageDetailService messageDetailService;


    @GetMapping("/")
    public List<MessageDetail> findAll() {
        return messageDetailService.findAll();
    }
    
    @GetMapping("/messageid/{id}")
    public List<MessageDetail> findByMessageId(@PathVariable Long id) {
        return messageDetailService.findByMessageId(id);
    }
    
    @PostMapping("/")
    public int save(@RequestBody MessageDetail messageDetail) {
    	return messageDetailService.save(messageDetail);
    }
}
