package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;
import com.zs.erh.service.facade.ProjetEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-equipe/projetequipe")
public class ProjetEquipeCERest {
    @Autowired
    ProjetEquipeService projetEquipeService;

    @GetMapping("/clientId/{id}/codeChefEquipe/{code}")
    public List<ProjetEquipe> findByProjetClientIdAndEquipeResponsableCode(@PathVariable Long id, @PathVariable String code) {
        return projetEquipeService.findByProjetClientIdAndEquipeResponsableCode(id, code);
    }

    @GetMapping("/codeChefEquipe/{code}")
    public List<ProjetEquipe> findByEquipeResponsableCode(@PathVariable String code) {
        return projetEquipeService.findByEquipeResponsableCode(code);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        projetEquipeService.deleteById(id);
    }

    @PostMapping("/dir/")
    public ProjetEquipe saveDirect(@RequestBody ProjetEquipe projetEquipe) {
        return projetEquipeService.saveDirect(projetEquipe);
    }

    @PostMapping("/")
    public int save(@RequestBody Projet projet, @RequestBody List<ProjetEquipe> projetEquipes) {
        return projetEquipeService.save(projet, projetEquipes);
    }

    @GetMapping("/")
    public List<ProjetEquipe> findAll() {
        return projetEquipeService.findAll();
    }

    @GetMapping("/projet/id/{id}")
    public List<ProjetEquipe> findByProjetId(@PathVariable Long id) {
        return projetEquipeService.findByProjetId(id);
    }

    @GetMapping("/projetId/{projetId}/chefAgenceId/{chefId}")
    public List<ProjetEquipe> findByProjetIdAndEquipeAgenceChefAgenceId(@PathVariable Long projetId, @PathVariable Long chefId) {
        return projetEquipeService.findByProjetIdAndEquipeAgenceChefAgenceId(projetId, chefId);
    }

    @GetMapping("/projet/code/{code}")
    public List<ProjetEquipe> findByProjetCode(@PathVariable String code) {
        return projetEquipeService.findByProjetCode(code);
    }

    @DeleteMapping("/projet/code/{code}")
    public int deleteByProjetCode(@PathVariable String code) {
        return projetEquipeService.deleteByProjetCode(code);
    }
}
