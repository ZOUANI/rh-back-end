package com.zs.erh.ws.provided;

import com.zs.erh.bean.Client;
import com.zs.erh.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestion-client/client")
public class ClientWS {
    @GetMapping("/libelle/{libelle}")
    public List<Client> findByEntrepriseLibelle(@PathVariable String libelle) {
        return clientService.findByEntrepriseLibelle(libelle);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle( @PathVariable String libelle) {
        return clientService.deleteByLibelle(libelle);
    }

    @Autowired
    private ClientService clientService;
}
