package com.zs.erh.ws.provided;

import com.zs.erh.bean.DemandeConge;
import com.zs.erh.service.facade.DemandeCongeService;
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
    public void deleteById(@PathVariable Long id) {
        demandeCongeService.deleteById(id);
    }
    @PostMapping("/")
    public int save(@RequestBody  DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }
    @PutMapping("/")
    public int update( @RequestBody DemandeConge demandeConge) {
        return demandeCongeService.update(demandeConge);
    }

    @Autowired
    private DemandeCongeService demandeCongeService;
}

