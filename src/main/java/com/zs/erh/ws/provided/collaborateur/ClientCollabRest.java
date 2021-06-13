package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Client;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/collaborateur/client")

public class ClientCollabRest {
    @Autowired
    private ClientService clientService;

    // Read Services C ( R ) U D

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/code/{code}")
    public List<Client> findByEntrepriseCode(@PathVariable String code) {
        return clientService.findByEntrepriseCode(code);
    }

    @PostMapping("/search")
    public List<Client> search(@RequestBody ClientVO clientVO) {
        return clientService.search(clientVO);
    }
}