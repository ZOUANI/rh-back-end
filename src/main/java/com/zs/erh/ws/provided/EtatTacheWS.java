package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatTache;
import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/etatTache")
public class EtatTacheWS {
    @Autowired
    private EtatTacheService etatTacheService;
    @GetMapping("/")
    public List<EtatTache> findAll() {
        return etatTacheService.findAll();
    }
}
