package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Ville;
import com.zs.erh.service.facade.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence/ville")
public class VilleRest {
    @Autowired
    private VilleService villeService;

    // Read Services Are Generales

    // Create services
    @PostMapping("/")
    public Ville save(@RequestBody Ville ville) {
        return villeService.save(ville);
    }

    // Update Services
    @PutMapping("/")
    public Ville update(@RequestBody Ville ville) {
        return villeService.update(ville);
    }

    // delete services
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return villeService.deleteByCode(code);
    }
}
