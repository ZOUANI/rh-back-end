package com.zs.erh.ws.provided.chef_agence;


import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.TacheService;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/tache")
public class TacheCARest {

    @Autowired
    private TacheService tacheService;

    @GetMapping("/collaborateurId/{id}")
    public List<Tache> findByMembreEquipeCollaborateurId(@PathVariable Long id) {
        return tacheService.findByMembreEquipeCollaborateurId(id);
    }

    @GetMapping("/codeGroupeTache/{code}")
    public List<Tache> findByGroupeTacheCode(@PathVariable String code) {
        return tacheService.findByGroupeTacheCode(code);
    }

    @GetMapping("/dateMin/{dateMin}/dateMax/{dateMax}")
    public List<CollaborateurVo> calcStatistiqueSuiviCollaborateur(@PathVariable Date dateMin, @PathVariable Date dateMax) {
        return tacheService.calcStatistiqueSuiviCollaborateur(dateMin, dateMax);
    }
    @PostMapping("/search")
    public List<Tache> search(@RequestBody TacheVo tacheVo){
        return tacheService.search(tacheVo);
    }

    //Create Methode
    @PostMapping("/")
    public Tache save(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    // Update Methode
    @PutMapping("/")
    public int updateTache(@RequestBody Tache tache) {
        return tacheService.updateTache(tache);
    }

    // Delete Methods
    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return tacheService.deleteByCode(code);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Tache> taches) {
        return tacheService.deleteMultiple(taches);
    }

    @DeleteMapping("GroupeTacheCode/{code}")
    public int deleteByGroupeTacheCode(@PathVariable String code) {
        return tacheService.deleteByGroupeTacheCode(code);
    }

    // Statistiques Services
    @PostMapping("calcStatistique/")
    public List<TacheVo> calcStatistique(@RequestBody TacheVo tacheVo) {
        return tacheService.calcStatistique(tacheVo);
    }

    @PostMapping("/suivreCollaborateurs")
    public List<CollaborateurVo> suivreCollaborateurs(@RequestBody CollaborateurVo collaborateurVo) {
        return tacheService.suivreCollaborateurs(collaborateurVo);
    }
}
