package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.TypePaiement;
import com.zs.erh.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/typePaiement")
public class TypePaiementCARest {
    @Autowired
    private TypePaiementService typePaiementService;

    
    @GetMapping("/")
    public List<TypePaiement> findAll() {
        return typePaiementService.findAll();
    }

    @GetMapping("/code/{code}")
    public TypePaiement findByCode(@PathVariable String code) {
        return typePaiementService.findByCode(code);
    }

    @GetMapping("/reference/{reference}")
    public TypePaiement findByReference(@PathVariable String reference) {
        return typePaiementService.findByReference(reference);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typePaiementService.deleteByCode(code);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return typePaiementService.deleteByReference(reference);
    }
}
