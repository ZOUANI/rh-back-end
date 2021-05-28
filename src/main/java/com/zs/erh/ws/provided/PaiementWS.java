package com.zs.erh.ws.provided;

import com.zs.erh.bean.Paiement;
import com.zs.erh.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/paiement")
public class PaiementWS {
    @Autowired
    private PaiementService paiementService;

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/code/{code}")
    public Paiement findByCode(@PathVariable String code) {
        return paiementService.findByCode(code);
    }

    @GetMapping("/reference/{reference}")
    public Paiement findByReference(@PathVariable String reference) {
        return paiementService.findByReference(reference);
    }

    @GetMapping("/codeFacture/{code}")
    public List<Paiement> findByFactureCode(@PathVariable String code) {
        return paiementService.findByFactureCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @PutMapping("/")
    public int updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paiementService.deleteByCode(code);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return paiementService.deleteByReference(reference);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Paiement> paiements) {
        return paiementService.deleteMultiple(paiements);
    }
}
