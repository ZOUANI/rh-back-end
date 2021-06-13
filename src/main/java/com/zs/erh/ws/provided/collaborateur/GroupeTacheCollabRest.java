package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.vo.GroupeTacheVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/collaborateur/groupeTache")
public class GroupeTacheCollabRest {
    @Autowired
    private GroupeTacheService groupeTacheService;

    // Read Services

    @GetMapping("/codeChefAgence/{code}")
    public List<GroupeTache> findByLotProjetAgenceChefAgenceCode(@PathVariable String code) {
        return groupeTacheService.findByLotProjetAgenceChefAgenceCode(code);
    }

    @GetMapping("/codeChefEquipe/{code}")
    public List<GroupeTache> findByEquipeResponsableCode(@PathVariable String code) {
        return groupeTacheService.findByEquipeResponsableCode(code);
    }

    @GetMapping("/codeCollaborateur/{code}")
    public List<GroupeTache> findByLotResponsableCode(@PathVariable String code) {
        return groupeTacheService.findByLotResponsableCode(code);
    }

    @GetMapping("/codeEquipe/{code}")
    public List<GroupeTache> findByEquipeCode(@PathVariable String code) {
        return groupeTacheService.findByEquipeCode(code);
    }

    @GetMapping("/codeLot/{code}")
    public List<GroupeTache> findByLotCode(@PathVariable String code) {
        return groupeTacheService.findByLotCode(code);
    }

    @PostMapping("/search")
    public List<GroupeTache> search(@RequestBody GroupeTacheVO groupeTacheVO) {
        return groupeTacheService.search(groupeTacheVO);
    }
}
