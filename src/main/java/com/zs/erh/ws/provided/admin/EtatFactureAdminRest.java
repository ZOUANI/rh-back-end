package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatFacture;
import com.zs.erh.service.facade.EtatFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/etatFacture")
public class EtatFactureAdminRest {
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
