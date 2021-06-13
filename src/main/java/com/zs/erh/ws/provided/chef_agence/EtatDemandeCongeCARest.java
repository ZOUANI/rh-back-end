package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.EtatDemandeConge;
import com.zs.erh.service.facade.EtatDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence/etatdemandeconge")
public class EtatDemandeCongeCARest {
    @GetMapping("/code/ {code}")
    public EtatDemandeConge findByCode(@PathVariable String code) {
        return etatDemandeCongeService.findByCode(code);
    }

    @GetMapping("/")
    public List<EtatDemandeConge> findAll() {
        return etatDemandeCongeService.findAll();
    }

    @GetMapping("/id/ {id}")
    public Optional<EtatDemandeConge> findById(@PathVariable Long id) {
        return etatDemandeCongeService.findById(id);
    }

    @Autowired
    private EtatDemandeCongeService etatDemandeCongeService;
}

