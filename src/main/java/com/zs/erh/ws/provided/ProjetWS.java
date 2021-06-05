package com.zs.erh.ws.provided;

import com.zs.erh.bean.ChefAgence;
import com.zs.erh.bean.Projet;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.imple.ProjetServiceImple;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/projet")
public class ProjetWS {
    @Autowired
    public ProjetService projetService;

    @Autowired
    public ProjetServiceImple projetServiceImple;

    @PostMapping("/search")
    public List<Projet> search(@RequestBody ProjetVO projetVo) {
        return projetServiceImple.search(projetVo);
    }

    @PostMapping("/")
    public Projet save(@RequestBody Projet projet) {
        return projetService.save(projet);
    }

    @GetMapping("/agence/chefAgence/{chefAgence}")
    public List<Projet> findByAgence_ChefAgence(@RequestBody ChefAgence chefAgence) {
        return projetService.findByAgence_ChefAgence(chefAgence);
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

    @GetMapping("/responsable/login/{login}")
    public List<Projet> findByResponsableLogin(@PathVariable String login) {
        return projetService.findByResponsableLogin(login);
    }
}