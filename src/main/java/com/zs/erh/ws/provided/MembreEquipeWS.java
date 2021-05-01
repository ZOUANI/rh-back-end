package com.zs.erh.ws.provided;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.service.facade.MembreEquipeService;
import com.zs.erh.service.imple.MembreEquipeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/membreEquipe")
public class MembreEquipeWS {
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

    @DeleteMapping("/equipe/code/{code}")
    public int deleteByEquipeCode(@PathVariable String code){
        return membreEquipeService.deleteByEquipeCode(code);
    }

    @DeleteMapping("/equipeCode/{codeEquipe}/collaborateurCode/{codeCollaborateur}")
    public int deleteByEquipeCodeAndCollaborateurCode(@PathVariable String codeEquipe,@PathVariable String codeCollaborateur){
        return membreEquipeService.deleteByEquipeCodeAndCollaborateurCode(codeEquipe,codeCollaborateur);
    }
    @PostMapping("/")
    public int save(@RequestBody MembreEquipe membreEquipe){
        return membreEquipeService.save(membreEquipe);
    }
    @PutMapping("/id/{id}")
    public int update(long id, MembreEquipe membreEquipe){
        return membreEquipeService.update(id,membreEquipe);
    }

}
