package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/collaborateur/equipe")
public class EquipeCollabRest {
    @Autowired
    private EquipeService equipeService;

    @GetMapping("/code/{code}")
    public Equipe findByCode(@PathVariable String code){
        return equipeService.findByCode(code);
    }
    @GetMapping("/etatEquipeCode/{code}")
    public List<Equipe> findByEtatEquipeCode(@PathVariable String code) {
        return this.equipeService.findByEtatEquipeCode(code);
    }

    @PostMapping("/search")
    public List<Equipe> search(@RequestBody EquipeVO equipeVO){
        return equipeService.search(equipeVO);
    }


    @GetMapping("/agenceChefAgenceCode/{code}")
    public List<Equipe> findByAgenceChefAgenceCode(@PathVariable String code){
        return equipeService.findByAgenceChefAgenceCode(code);
    }
}
