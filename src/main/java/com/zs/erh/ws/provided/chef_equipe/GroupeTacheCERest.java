package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.vo.GroupeTacheVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-equipe/groupeTache")
public class GroupeTacheCERest {
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

    // Create Services

    @PostMapping("/")
    public GroupeTache save(@RequestBody GroupeTache groupeTache) {
        return groupeTacheService.save(groupeTache);
    }

    // Update Services
    @PutMapping("/")
    public int updateGroupeTache(@RequestBody GroupeTache groupeTache) {
        return groupeTacheService.updateGroupeTache(groupeTache);
    }

    // Delete Services
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return groupeTacheService.deleteByCode(code);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<GroupeTache> groupeTaches) {
        return groupeTacheService.deleteMultiple(groupeTaches);
    }

    @DeleteMapping("/DeleteLotCode/{code}")
    public int deleteByLotCode(@PathVariable String code) {
        return groupeTacheService.deleteByLotCode(code);
    }
}
