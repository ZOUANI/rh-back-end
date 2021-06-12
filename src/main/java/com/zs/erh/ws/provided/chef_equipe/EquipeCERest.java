package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/chef-equipe/equipe")
public class EquipeCERest {
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
    @GetMapping("/collaborateur/code/{code}")
    public List<Equipe> findByResponsableCode(@PathVariable String code) {
        return equipeService.findByResponsableCode(code);
    }
    @GetMapping("/agenceChefAgenceCode/{code}")
    public List<Equipe> findByAgenceChefAgenceCode(@PathVariable String code){
        return equipeService.findByAgenceChefAgenceCode(code);
    }

    @PostMapping("/search")
    public List<Equipe> search(@RequestBody EquipeVO equipeVO){
        return equipeService.search(equipeVO);
    }

}
