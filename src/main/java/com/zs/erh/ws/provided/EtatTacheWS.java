package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatTache;
import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> origin/master

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/etatTache")
public class EtatTacheWS {
    @Autowired
    private EtatTacheService etatTacheService;
<<<<<<< HEAD

=======
>>>>>>> origin/master
    @GetMapping("/")
    public List<EtatTache> findAll() {
        return etatTacheService.findAll();
    }
<<<<<<< HEAD

    @GetMapping("/code/{code}")
    public EtatTache findByCode(@PathVariable String code) {
        return etatTacheService.findByCode(code);
    }
=======
>>>>>>> origin/master
}
