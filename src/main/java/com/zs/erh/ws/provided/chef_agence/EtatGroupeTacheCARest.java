package com.zs.erh.ws.provided.chef_agence;


import com.zs.erh.bean.EtatGroupeTache;
import com.zs.erh.service.facade.EtatGroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/etatGroupeTache")
public class EtatGroupeTacheCARest {

    @GetMapping("/")
    public List<EtatGroupeTache> findAll() {
        return etatGroupeTacheService.findAll();
    }

    @GetMapping("/code/{code}")
    public EtatGroupeTache findByCode(@PathVariable String code) {
        return etatGroupeTacheService.findByCode(code);
    }

    @Autowired
    public EtatGroupeTacheService etatGroupeTacheService;
}
