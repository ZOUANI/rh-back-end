package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Client;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/chef-agence/client")

public class ClientRest {
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

    // Delete services
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return clientService.deleteByCode(code);
    }

    @PostMapping("/multiples-codes")
    public int deleteByCode(@RequestBody List<Client> clients) {
        return clientService.deleteByCode(clients);
    }

    
    // Update Services
    @PutMapping("/")
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }

    // Create Services
    @PostMapping("/")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
}