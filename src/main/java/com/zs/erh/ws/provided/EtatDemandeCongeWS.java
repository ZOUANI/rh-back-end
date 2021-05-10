package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatDemandeConge;
import com.zs.erh.service.facade.EtatDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("etat-demande-conge/etatdemandeconge")
public class EtatDemandeCongeWS {
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

