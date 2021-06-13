package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Projet;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/projet")
public class ProjetCARest {
    @Autowired
    public ProjetService projetService;

    //Read Methodes

    @GetMapping("/chefAgenceId/{id}")
    public List<Projet> findByAgenceChefAgenceId(@PathVariable Long id) {
        return projetService.findByAgenceChefAgenceId(id);
    }

    @GetMapping("/agence/chefAgence/code/{code}")
    public List<Projet> findByAgenceChefAgenceCode(@PathVariable String code) {
        return projetService.findByAgenceChefAgenceCode(code);
    }

    @PostMapping("/search")
    public List<Projet> search(@RequestBody ProjetVO projetVo) {
        return projetService.search(projetVo);
    }


    @GetMapping("/client/id/{id}")
    public List<Projet> findByClientId(@PathVariable Long id) {
        return projetService.findByClientId(id);
    }

    @GetMapping("/clientId/{id}/codeChefAgence/{code}")
    public List<Projet> findByClientIdAndAgenceChefAgenceCode(@PathVariable Long id, @PathVariable String code) {
        return projetService.findByClientIdAndAgenceChefAgenceCode(id, code);
    }

    @GetMapping("/clientId/{id}/codeResponsable/{code}")
    public List<Projet> findByClientIdAndResponsableCode(@PathVariable Long id, @PathVariable String code) {
        return projetService.findByClientIdAndResponsableCode(id, code);
    }

    // Create Services
    @PostMapping("/")
    public Projet save(@RequestBody Projet projet) {
        return projetService.save(projet);
    }



    // Update Methods
    @PutMapping("/")
    public void update(@RequestBody Projet projet) {
         projetService.update(projet);
    }

    // Delete Methods

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return projetService.deleteByCode(code);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Projet> projets) {
        return projetService.deleteMultiple(projets);
    }

}

