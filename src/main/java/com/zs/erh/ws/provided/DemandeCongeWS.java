package com.zs.erh.ws.provided;

import com.zs.erh.bean.DemandeConge;
import com.zs.erh.service.facade.DemandeCongeService;
import com.zs.erh.service.vo.DemandeCongeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("demande-conge/conge")
public class DemandeCongeWS {
    @GetMapping("/id/{id}")
    public Optional<DemandeConge> findById(Long id) {
        return demandeCongeService.findById(id);
    }

    @GetMapping("/code/{code}")
    public List<DemandeConge> findByEtatDemandeCongeCode(String code) {
        return demandeCongeService.findByEtatDemandeCongeCode(code);
    }
    @GetMapping("/")
    public List<DemandeConge> findAll() {
        return demandeCongeService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable  Long id) {
        return demandeCongeService.deleteById(id);
    }
    @PostMapping("/")
    public int save(@RequestBody  DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }
    @PutMapping("/")
    public int update( @RequestBody DemandeConge demandeConge) {
        return demandeCongeService.update(demandeConge);
    }

    @GetMapping("/calcNombreJourTotal/collaborateurId/{collaborateurId}/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public Long calcNombreJourTotal(Long collaborateurId, Date dateDebut, Date dateFin) {
        return demandeCongeService.calcNombreJourTotal(collaborateurId, dateDebut, dateFin);
    }

    @GetMapping("/collaborateurId/{collaborateurId}/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public List<DemandeCongeVo> findByCollaborateurAndDateMinAndMax(@PathVariable Long collaborateurId, @PathVariable Date dateDebut, @PathVariable Date dateFin) {
        return demandeCongeService.findByCollaborateurAndDateMinAndMax(collaborateurId, dateDebut, dateFin);
    }

    @Autowired
    private DemandeCongeService demandeCongeService;

}

