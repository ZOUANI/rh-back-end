package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.facade.EntrepriseService;
import com.zs.erh.service.vo.EntrepriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/admin/entreprise")
public class EntrepriseAdminRest {

    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping("/")
    public List<Entreprise> findAll() {
        return entrepriseService.findAll();
    }

    @GetMapping("/code/{code}/libelle/{libelle}")
    public List<Entreprise> findByCodeLikeAndLibelleLike( @PathVariable String code,@PathVariable String libelle) {
        return entrepriseService.findByCodeLikeAndLibelleLike(code, libelle);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return entrepriseService.deleteByCode(code);
    }



    @PostMapping("/")
    public Entreprise save(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }

    @PutMapping("/")
    public Entreprise update(@RequestBody Entreprise entreprise) {
        return entrepriseService.update(entreprise);
    }

    @PostMapping("/findByCriteria")
    public List<Entreprise> findByCriteria( @RequestBody EntrepriseVO entrepriseVO) {
        return entrepriseService.findByCriteria(entrepriseVO);
    }

    @PostMapping("/multiples-codes")
    public int deleteByCode(@RequestBody List<Entreprise> entreprises) {
        return entrepriseService.deleteByCode(entreprises);
    }
}
