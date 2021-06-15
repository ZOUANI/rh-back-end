package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.MessageDetail;
import com.zs.erh.service.facade.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/collaborateur/message-detail")
public class MessageDetailCollabRest {
    @Autowired
    private MessageDetailService messageDetailService;


    @GetMapping("/")
    public List<MessageDetail> findAll() {
        return messageDetailService.findAll();
    }
}
