package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;
import com.zs.erh.service.facade.ProjetEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/collaborateur/projetequipe")
public class ProjetEquipeCRest {
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
}
