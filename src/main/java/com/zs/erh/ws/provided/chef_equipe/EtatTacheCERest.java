package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.EtatTache;
import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-equipe/etatTache")
public class EtatTacheCERest {
    @Autowired
    private EtatTacheService etatTacheService;

    @GetMapping("/")
    public List<EtatTache> findAll() {
        return etatTacheService.findAll();
    }

    @GetMapping("/code/{code}")
    public EtatTache findByCode(@PathVariable String code) {
        return etatTacheService.findByCode(code);
    }
}
