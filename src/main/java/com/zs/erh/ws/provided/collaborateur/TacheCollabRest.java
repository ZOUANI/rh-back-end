package com.zs.erh.ws.provided.collaborateur;


import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.TacheService;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/collaborateur/tache")
public class TacheCollabRest {

    @Autowired
    private TacheService tacheService;

    @GetMapping("/groupeId/{grpId}/collaborateurId/{collabId}")
    public List<Tache> findByGroupeTacheIdAndMembreEquipeCollaborateurId(@PathVariable Long grpId, @PathVariable Long collabId) {
        return tacheService.findByGroupeTacheIdAndMembreEquipeCollaborateurId(grpId, collabId);
    }

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
    @PostMapping("/saveForCollaborateur")
    public Tache saveForCollaborateur(@RequestBody Tache tache) {
        return tacheService.saveForCollaborateur(tache);
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
}
