package com.zs.erh.ws.provided;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.facade.EntrepriseService;
import com.zs.erh.service.vo.EntrepriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gestion-entreprise/entreprise")
public class EntrepriseWS {

    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping("/code/{code}")
    public Entreprise findByCode( @PathVariable String code) {
        return entrepriseService.findByCode(code);
    }
    @GetMapping("/code/{code}/libelle/{libelle}")
    public List<Entreprise> findByCodeLikeAndLibelleLike( @PathVariable String code,@PathVariable String libelle) {
        return entrepriseService.findByCodeLikeAndLibelleLike(code, libelle);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return entrepriseService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Entreprise> findAll() {
        return entrepriseService.findAll();
    }
    @PostMapping("/")
    public Entreprise save(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }
    @GetMapping("/id/{id}")
    public Optional<Entreprise> findById( @PathVariable Long id) {
        return entrepriseService.findById(id);
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
