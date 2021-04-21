package com.zs.erh.ws.provided;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.service.facade.MembreEquipeService;
import com.zs.erh.service.imple.MembreEquipeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembreEquipeWS {
    @Autowired
    private MembreEquipeService membreEquipeService;

    @GetMapping("/")
    public List<MembreEquipe> findAll(){
        return membreEquipeService.findAll();
    }

    @GetMapping("/collaborateurCode/{code}")
    List<MembreEquipe> findByCollaborateurCode(@PathVariable String code){
        return membreEquipeService.findByCollaborateurCode(code);
    }

    @GetMapping("/equipeCode/{code}")
    MembreEquipe findByEquipeCode(@PathVariable String code){
        return membreEquipeService.findByEquipeCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByEquipeCode(@PathVariable String code){
        return membreEquipeService.deleteByEquipeCode(code);
    }



}
