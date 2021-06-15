package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Message;
import com.zs.erh.service.facade.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/collaborateur/message")
public class MessageCollabRest {
    @Autowired
    private MessageService messageService;
    @GetMapping("/login/{login}")
    public List<Message> findBySourceLogin(@PathVariable String login) {
        return messageService.findBySourceLogin(login);
    }

    @GetMapping("/")
    public List<Message> findAll() {
        return messageService.findAll();
    }
    @PostMapping("/")
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
}
