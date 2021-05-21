package com.zs.erh.ws.provided;

import com.zs.erh.bean.Facture;
import com.zs.erh.service.facade.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/facture")
public class FactureWS {
    @Autowired
    private FactureService factureService;

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @GetMapping("/code/{code}")
    public Facture findByCode(String code) {
        return factureService.findByCode(code);
    }
    @PostMapping("/")
    public int save(Facture facture) {
        return factureService.save(facture);
    }
}
