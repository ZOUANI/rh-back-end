package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Projet;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.imple.ProjetServiceImple;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/projet")
public class ProjetAdminRest {

    @Autowired
    public ProjetService projetService;

    @PostMapping("/search")
    public List<Projet> search(@RequestBody ProjetVO projetVo) {
        return projetServiceImple.search(projetVo);
    }

    @Autowired
    public ProjetServiceImple projetServiceImple;

    @PostMapping("/")
    public Projet save(@RequestBody Projet projet) {
        return projetService.save(projet);
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

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Projet> projets) {
        return projetService.deleteMultiple(projets);
    }

    @PutMapping("/")
    public void update(@RequestBody Projet projet) {
        projetService.update(projet);
    }

    @GetMapping("/id/{id}")
    public Projet findId(@PathVariable Long id) {
        return projetService.findId(id);
    }

    @GetMapping("/client/id/{id}")
    public List<Projet> findByClientId(@PathVariable Long id) {
        return projetService.findByClientId(id);
    }
}

