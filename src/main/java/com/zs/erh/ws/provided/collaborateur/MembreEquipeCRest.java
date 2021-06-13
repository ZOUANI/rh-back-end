package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.service.facade.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/collaborateur/membreEquipe")
public class MembreEquipeCRest {


    @Autowired
    private MembreEquipeService membreEquipeService;

    @GetMapping("/collaborateur/code/{code}")
    List<MembreEquipe> findByCollaborateurCode(@PathVariable String code){
        return membreEquipeService.findByCollaborateurCode(code);
    }

    @GetMapping("/equipe/code/{code}")
    List<MembreEquipe> findByEquipeCode(@PathVariable String code){
        return membreEquipeService.findByEquipeCode(code);
    }

    @GetMapping("/equipeCode/{codeEquipe}/collaborateurCode/{codeCollaborateur}")
    public MembreEquipe findByEquipeCodeAndCollaborateurCode(@PathVariable String codeEquipe,@PathVariable String codeCollaborateur) {
        return membreEquipeService.findByEquipeCodeAndCollaborateurCode(codeEquipe, codeCollaborateur);
    }
    @PutMapping("/")
    public MembreEquipe update(@RequestBody MembreEquipe membreEquipe){
        return membreEquipeService.update(membreEquipe);
    }
}
