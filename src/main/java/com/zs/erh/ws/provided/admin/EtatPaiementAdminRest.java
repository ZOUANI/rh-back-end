package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatPaiement;
import com.zs.erh.service.facade.EtatPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/etatPaiement")
public class EtatPaiementAdminRest {
    @Autowired
    private EtatPaiementService etatPaiementService;

    @GetMapping("/")
    public List<EtatPaiement> findAll() {
        return etatPaiementService.findAll();
    }

    @GetMapping("/code/{code}")
    public EtatPaiement findByCode(@PathVariable String code) {
        return etatPaiementService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatPaiementService.deleteByCode(code);
    }
}
