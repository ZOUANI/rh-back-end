package com.zs.erh.ws.provided;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.imple.EquipeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("maneo-rh/equipe")
public class EquipeWS {
    @Autowired
    private EquipeService equipeService;

    @GetMapping("/")
    public List<Equipe> findAll(){
        return equipeService.findAll();
    }

    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code){
        return equipeService.findByCode(code);
    }
    @GetMapping("/etatEquipeCode/{code}")
    public List<Equipe> findByEtatEquipeCode(@PathVariable String code) {
        return this.equipeService.findByEtatEquipeCode(code);
    }
    @GetMapping("/collaborateur/Code/{code}")
    public Equipe findByResponsableCode(@PathVariable String code) {
        return equipeService.findByResponsableCode(code);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return equipeService.deleteByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Equipe equipe){
        return  equipeService.save(equipe);
    }

    @PutMapping("/id/{id}")
    public int update(@PathVariable long id, @RequestBody Equipe equipe){
        return equipeService.update(id,equipe);
    }
}
