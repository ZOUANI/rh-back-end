package com.zs.erh.ws.provided;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Projet;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.imple.ProjetServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/projet")
public class ProjetWS {
    @Autowired
    public ProjetService projetService;

    @PostMapping("/")
    public int save(@RequestBody Projet projet) {
        return projetService.save(projet);
    }

    @GetMapping("/nro/code/{code}")
    public List<Projet> findByNroCode(@PathVariable String code) {
        return projetService.findByNroCode(code);
    }

    @GetMapping("/")
    public List<Projet> findAll() {
        return projetService.findAll();
    }

    @GetMapping("/code/{code}")
    public Projet findByCode(@PathVariable String code) {
        return projetService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return projetService.deleteByCode(code);
    }
}

