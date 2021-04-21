package com.zs.erh.ws.provided;


import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "maneo-rh/tache")
public class TacheWS {
    @Autowired
    private TacheService tacheService;

    @GetMapping("/")
    public List<Tache> findAll() {
        return tacheService.findAll();
    }

    @GetMapping("/code/{code}")
    public Tache findByCode(@PathVariable String code) {
        return tacheService.findByCode(code);
    }

    @GetMapping("/codeGroupeTache/{code}")
    public List<Tache> findByGroupeTacheCode(@PathVariable String code) {
        return tacheService.findByGroupeTacheCode(code);
    }

    @DeleteMapping("GroupeTacheCode/{code}")
    public int deleteByGroupeTacheCode(@PathVariable String Code) {
        return tacheService.deleteByGroupeTacheCode(Code);
    }
}