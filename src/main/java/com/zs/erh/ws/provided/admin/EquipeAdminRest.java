package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/admin/equipe")
public class EquipeAdminRest {
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

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return equipeService.deleteByCode(code);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable long id) {
        equipeService.deleteById(id);
        return 1;
    }

    @PostMapping("/")
    public Equipe save(@RequestBody Equipe equipe){
        return  equipeService.save(equipe);
    }
    @PostMapping("/search")
    public List<Equipe> search(@RequestBody EquipeVO equipeVO){
        return equipeService.search(equipeVO);
    }

    @PutMapping("/update")
    public Equipe update(@RequestBody Equipe equipe){
        return equipeService.update(equipe);
    }

    @GetMapping("/agenceChefAgenceCode/{code}")
    public List<Equipe> findByAgenceChefAgenceCode(@PathVariable String code){
        return equipeService.findByAgenceChefAgenceCode(code);
    }
}
