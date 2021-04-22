package com.zs.erh.ws.provided;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.imple.EquipeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EquipeWS {
    @Autowired
    private EquipeServiceImple equipeServiceImple;

    @GetMapping("/")
    public List<Equipe> findAll(){
        return equipeServiceImple.findAll();
    }

    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code){
        return equipeServiceImple.findByCode(code);
    }
    @GetMapping("/etatEquipeCode/{code}")
    public List<Equipe> findByEtatEquipeCode(@PathVariable String code) {
        return this.equipeServiceImple.findByEtatEquipeCode(code);
    }
    @GetMapping("/respoCode/{code}")
    public Equipe findByResponsableCode(String code) {
        return equipeServiceImple.findByResponsableCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return equipeServiceImple.deleteByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Equipe equipe){
        return  equipeServiceImple.save(equipe);
    }
}
