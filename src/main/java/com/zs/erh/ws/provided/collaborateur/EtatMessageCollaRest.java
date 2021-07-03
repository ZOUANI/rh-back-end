package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.EtatMessage;
import com.zs.erh.service.facade.EtatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/collaborateur/etat-message")
public class EtatMessageCollaRest {
    @Autowired
    private EtatMessageService etatMessageService;


    @GetMapping("/")
    public List<EtatMessage> findAll() {
        return etatMessageService.findAll();
    }
}
