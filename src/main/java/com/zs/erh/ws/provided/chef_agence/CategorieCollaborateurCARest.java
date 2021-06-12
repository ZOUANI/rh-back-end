package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.CategorieCollaborateur;
import com.zs.erh.service.facade.CategorieCollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("maneo-rh/chef-agence/categorieCollaborateur")
public class CategorieCollaborateurCARest {
    @Autowired
    private CategorieCollaborateurService categorieCollaborateurService;

    @GetMapping("/code/{code}")
    public CategorieCollaborateur findByCode(@PathVariable String code) {
        return categorieCollaborateurService.findByCode(code);
    }
}
