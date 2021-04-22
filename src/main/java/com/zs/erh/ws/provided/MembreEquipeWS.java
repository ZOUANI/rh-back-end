package com.zs.erh.ws.provided;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.service.facade.MembreEquipeService;
import com.zs.erh.service.imple.MembreEquipeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MembreEquipe/")
public class MembreEquipeWS {
    @Autowired
    private MembreEquipeService membreEquipeService;

    @GetMapping("/collaborateurCode/{code}")
    List<MembreEquipe> findByCollaborateurCode(@PathVariable String code){
        return membreEquipeService.findByCollaborateurCode(code);
    }

    @GetMapping("/equipeCode/{code}")
    List<MembreEquipe> findByEquipeCode(@PathVariable String code){
        return membreEquipeService.findByEquipeCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByEquipeCode(@PathVariable String code){
        return membreEquipeService.deleteByEquipeCode(code);
    }



}
