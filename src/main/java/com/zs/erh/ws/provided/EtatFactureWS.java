package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatFacture;
import com.zs.erh.bean.EtatTache;
import com.zs.erh.service.facade.EtatFactureService;
import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/etatFacture")
public class EtatFactureWS {
    @Autowired
    private EtatFactureService etatFactureService;

    @GetMapping("/")
    public List<EtatFacture> findAll() {
        return etatFactureService.findAll();
    }

    @GetMapping("/code/{code}")
    public EtatFacture findByCode(@PathVariable String code) {
        return etatFactureService.findByCode(code);
    }
}
