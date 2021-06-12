package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Projet;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/projet")
public class ProjetCERest {
    @Autowired
    public ProjetService projetService;

    //Read Methodes

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
}

