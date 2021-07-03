package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Message;
import com.zs.erh.service.facade.MessageService;
import com.zs.erh.service.vo.MessageVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/collaborateur/message")
public class MessageCollabRest {
    @Autowired
    private MessageService messageService;
    
    
    @GetMapping("/login/{login}")
    public List<Message> findBySourceLogin(@PathVariable String login) {
        return messageService.findBySourceLogin(login);
    }
    
    @GetMapping("/etatMessageCode/{code}")
    public List<Message> findByEtatMessageCode(@PathVariable String code) {
        return this.messageService.findByEtatMessageCode(code);
    }

    @GetMapping("/")
    public List<Message> findAll() {
        return messageService.findAll();
    }
    @PostMapping("/")
    public Message save(@RequestBody Message message) {
        return messageService.saveMD(message, message.getMessageDetails());

    }
    @PostMapping("/search")
    public List<Message> searchMessage(@RequestBody MessageVO messageVO) {
        return messageService.searchMessage(messageVO);
    }
}
