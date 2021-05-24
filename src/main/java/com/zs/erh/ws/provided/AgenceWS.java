package com.zs.erh.ws.provided;

import com.zs.erh.bean.Agence;
import com.zs.erh.service.facade.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/agence")
public class AgenceWS {
    @Autowired
    private AgenceService agenceService;
    @GetMapping("/codec/{codec}")
    public Agence findByChefAgenceCode(@PathVariable String codec) {
        return agenceService.findByChefAgenceCode(codec);
    }

    @GetMapping("/code/{code}")
    public Agence findByCode(@PathVariable String code) {
        return agenceService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<Agence> findById(@PathVariable Long id) {
        return agenceService.findById(id);
    }
    @GetMapping("/codee/{codee}")
    public List<Agence> findByEtatAgenceCode(@PathVariable String codee) {
        return agenceService.findByEtatAgenceCode(codee);
    }
    @GetMapping("/codev/{codev}")
    public List<Agence> findByVilleCode(@PathVariable String codev) {
        return agenceService.findByVilleCode(codev);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return agenceService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }
    @PostMapping("/")
    public Agence save(@RequestBody Agence agence) {
        return agenceService.save(agence);
    }
    @PutMapping("/")
    public Agence update(@RequestBody Agence agence) {
        return agenceService.update(agence);
    }
}
