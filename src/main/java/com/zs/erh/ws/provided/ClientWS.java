package com.zs.erh.ws.provided;

import com.zs.erh.bean.Client;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.vo.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gestion-clients/client")
public class ClientWS {
    @GetMapping("/code/{code}")
    public List<Client> findByEntrepriseCode(@PathVariable String code) {
        return clientService.findByEntrepriseCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode( @PathVariable String code) {
        return clientService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/search")
    public List<Client> search(@RequestBody ClientVO clientVO) {
        return clientService.search(clientVO);
    }
    @GetMapping("/id/{id}")
    public Optional<Client> findById( @PathVariable Long id) {
        return clientService.findById(id);
    }

    @Autowired
    private ClientService clientService;
}
