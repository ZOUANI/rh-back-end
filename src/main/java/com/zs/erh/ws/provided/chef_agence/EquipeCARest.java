package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/chef-agence/equipe")
public class EquipeCARest {
    @Autowired
    private EquipeService equipeService;
    // Create
    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code){
        return equipeService.findByCode(code);
    }
    @GetMapping("/etatEquipeCode/{code}")
    public List<Equipe> findByEtatEquipeCode(@PathVariable String code) {
        return this.equipeService.findByEtatEquipeCode(code);
    }
    @GetMapping("/collaborateur/code/{code}")
    public List<Equipe> findByResponsableCode(@PathVariable String code) {
        return equipeService.findByResponsableCode(code);
    }
    @GetMapping("/agenceChefAgenceCode/{code}")
    public List<Equipe> findByAgenceChefAgenceCode(@PathVariable String code){
        return equipeService.findByAgenceChefAgenceCode(code);
    }
    // Delete

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
    // Update
    @PutMapping("/update")
    public Equipe update(@RequestBody Equipe equipe){
        return equipeService.update(equipe);
    }

}
