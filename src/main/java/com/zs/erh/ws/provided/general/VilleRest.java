package com.zs.erh.ws.provided.general;

import com.zs.erh.bean.Ville;
import com.zs.erh.service.facade.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/general/ville")
public class VilleRest {
    @Autowired
    private VilleService villeService;

    // Tout le monde a le doit de voir les ville

    @GetMapping("/")
    public List<Ville> findAll() {
        return villeService.findAll();
    }


    @GetMapping("/codep/{codep}")
    public List<Ville> findByPaysCode(@PathVariable String codep) {
        return villeService.findByPaysCode(codep);
    }
}
