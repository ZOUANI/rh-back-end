package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.DemandeConge;
import com.zs.erh.service.facade.DemandeCongeService;
import com.zs.erh.service.vo.DemandeCongeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence/conge")
public class DemandeCongeCARest {
    @Autowired
    private DemandeCongeService demandeCongeService;
    @GetMapping("/codechef/{codechef}")
    public List<DemandeConge> findByCollaborateurAgenceChefAgenceCode(@PathVariable String codechef) {
        return demandeCongeService.findByCollaborateurAgenceChefAgenceCode(codechef);
    }

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

    @PostMapping("/")
    public DemandeConge save(@RequestBody  DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }
    @PutMapping("/")
    public DemandeConge update( @RequestBody DemandeConge demandeConge) {
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

    @DeleteMapping("/code/{code}")
    public int deleteByCode( @PathVariable String code) {
        return demandeCongeService.deleteByCode(code);
    }
    @GetMapping("/codee/{codee}")
    public DemandeConge findByCode(@PathVariable String codee) {
        return demandeCongeService.findByCode(codee);
    }
    @PostMapping ("/delete-multiple-by-code")
    public int deleteByCode(@RequestBody List<DemandeConge> demandesConge) {
        return demandeCongeService.deleteByCode(demandesConge);
    }
    @PostMapping("/findByCriteriaConge")
    public List<DemandeConge> findByCriteriaConge(@RequestBody DemandeCongeVo demandeCongeVO) {
        return demandeCongeService.findByCriteriaConge(demandeCongeVO);
    }

    @PreAuthorize("hasRole('CHEF_AGENCE') or hasRole('ADMIN') or hasRole('COLLABORATEUR')")
    @GetMapping("/codec/{codec}")
    public List<DemandeConge> findByCollaborateurCode(@PathVariable String codec) {
        return demandeCongeService.findByCollaborateurCode(codec);
    }
}

