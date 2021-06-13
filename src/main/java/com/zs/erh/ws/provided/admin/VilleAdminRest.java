package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Ville;
import com.zs.erh.service.facade.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/admin/ville")
public class VilleAdminRest {
    @Autowired
    private VilleService villeService;



    @GetMapping("/code/{code}")
    public Ville findByCode(@PathVariable String code) {
        return villeService.findByCode(code);
    }
    @GetMapping("id/{id}")
    public Optional<Ville> findById(@PathVariable Long id) {
        return villeService.findById(id);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return villeService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }
    @GetMapping("/codep/{codep}")
    public List<Ville> findByPaysCode(@PathVariable String codep) {
        return villeService.findByPaysCode(codep);
    }
    @PostMapping("/")
    public Ville save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }
    @PutMapping("/")
    public Ville update(@RequestBody Ville ville) {
        return villeService.update(ville);
    }
}
