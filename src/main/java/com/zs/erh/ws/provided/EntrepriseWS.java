package com.zs.erh.ws.provided;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.facade.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gestion-entreprise/entreprise")
public class EntrepriseWS {
    @GetMapping("/libelle/{libelle}")
    public Entreprise findByLibelle( @PathVariable String libelle) {
        return entrepriseService.findByLibelle(libelle);
    }
    @GetMapping("/libelle/{libelle}/code/{code}")
    public List<Entreprise> findByLibelleLikeAndCodeLike( @PathVariable String libelle,@PathVariable String code) {
        return entrepriseService.findByLibelleLikeAndCodeLike(libelle, code);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return entrepriseService.deleteByLibelle(libelle);
    }
    @GetMapping("/")
    public List<Entreprise> findAll() {
        return entrepriseService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }
    public Optional<Entreprise> findById(@PathVariable Long id) {
        return entrepriseService.findById(id);
    }
    @PutMapping("/updateEntreprise/id/{id}")
    public int updateEntreprise(Entreprise entreprise,@PathVariable Long id) {
        return entrepriseService.updateEntreprise(entreprise, id);
    }


    @Autowired
    private EntrepriseService entrepriseService;
}
