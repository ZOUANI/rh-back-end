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
    @GetMapping("/")
    public List<MembreEquipe> findAll() {
        return membreEquipeService.findAll();
    }

    @GetMapping("/equipe/code/{code}")
    List<MembreEquipe> findByEquipeCode(@PathVariable String code){
        return membreEquipeService.findByEquipeCode(code);
    }

    @GetMapping("/equipeCode/{codeEquipe}/collaborateurCode/{codeCollaborateur}")
    public MembreEquipe findByEquipeCodeAndCollaborateurCode(@PathVariable String codeEquipe,@PathVariable String codeCollaborateur) {
        return membreEquipeService.findByEquipeCodeAndCollaborateurCode(codeEquipe, codeCollaborateur);
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
    public MembreEquipe save(@RequestBody MembreEquipe membreEquipe){
        return membreEquipeService.save(membreEquipe);
    }
    @PutMapping("/")
    public MembreEquipe update(@RequestBody MembreEquipe membreEquipe){
        return membreEquipeService.update(membreEquipe);
    }

    @GetMapping("/equipe/id/{id}")
    public List<MembreEquipe> findByEquipeId(@PathVariable Long id) {
        return membreEquipeService.findByEquipeId(id);
    }
}
