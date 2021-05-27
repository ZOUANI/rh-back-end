package com.zs.erh.ws.provided;


import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.TacheService;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/tache")
public class TacheWS {
    @Autowired
    private TacheService tacheService;

    @GetMapping("/")
    public List<Tache> findAll() {
        return tacheService.findAll();
    }

    @GetMapping("/code/{code}")
    public Tache findByCode(@PathVariable String code) {
        return tacheService.findByCode(code);
    }

    @GetMapping("/codeGroupeTache/{code}")
    public List<Tache> findByGroupeTacheCode(@PathVariable String code) {
        return tacheService.findByGroupeTacheCode(code);
    }

    @PostMapping("/")
    public Tache save(@RequestBody Tache tache) {
        return tacheService.save(tache);
    }

    @PutMapping("/")
    public int updateTache(@RequestBody Tache tache) {
        return tacheService.updateTache(tache);
    }

    @DeleteMapping("GroupeTacheCode/{code}")
    public int deleteByGroupeTacheCode(@PathVariable String code) {
        return tacheService.deleteByGroupeTacheCode(code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return tacheService.deleteByCode(code);
    }

    @PostMapping("calcStatistique/")
    public List<TacheVo> calcStatistique(@RequestBody TacheVo tacheVo) {
        return tacheService.calcStatistique(tacheVo);
    }

    @PostMapping("/suivreCollaborateurs")
    public List<CollaborateurVo> suivreCollaborateurs(@RequestBody CollaborateurVo collaborateurVo) {
        return tacheService.suivreCollaborateurs(collaborateurVo);
    }

    @GetMapping("/dateMin/{dateMin}/dateMax/{dateMax}")
    public List<CollaborateurVo> calcStatistiqueSuiviCollaborateur(@PathVariable Date dateMin, @PathVariable Date dateMax) {
        return tacheService.calcStatistiqueSuiviCollaborateur(dateMin, dateMax);
    }
    @PostMapping("/search")
    public List<Tache> search(@RequestBody TacheVo tacheVo){
        return tacheService.search(tacheVo);
    }
}
