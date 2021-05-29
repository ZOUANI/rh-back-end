package com.zs.erh.ws.provided;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.vo.GroupeTacheVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "maneo-rh/groupeTache")
public class GroupeTacheWS {
    @Autowired
    private GroupeTacheService groupeTacheService;

    @GetMapping("/codeChefAgence/{code}")
    public List<GroupeTache> findByLotProjetAgenceChefAgenceCode(@PathVariable String code) {
        return groupeTacheService.findByLotProjetAgenceChefAgenceCode(code);
    }

    @GetMapping("/codeEquipe/{code}")
    public List<GroupeTache> findByEquipeCode(@PathVariable String code) {
        return groupeTacheService.findByEquipeCode(code);
    }

    @GetMapping("/")
    public List<GroupeTache> findAll() {
        return groupeTacheService.findAll();
    }

    @GetMapping("/codeLot/{code}")
    public List<GroupeTache> findByLotCode(@PathVariable String code) {
        return groupeTacheService.findByLotCode(code);
    }

    @GetMapping("/code/{code}")
    public GroupeTache findByCode(@PathVariable String code) {
        return groupeTacheService.findByCode(code);
    }

    @PostMapping("/")
    public GroupeTache save(@RequestBody GroupeTache groupeTache) {
        return groupeTacheService.save(groupeTache);
    }

    @DeleteMapping("/DeleteLotCode/{code}")
    public int deleteByLotCode(@PathVariable String code) {
        return groupeTacheService.deleteByLotCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return groupeTacheService.deleteByCode(code);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<GroupeTache> groupeTaches) {
        return groupeTacheService.deleteMultiple(groupeTaches);
    }

    @GetMapping("/id/{id}")
    public Optional<GroupeTache> findById(@PathVariable Long id) {
        return groupeTacheService.findById(id);
    }

    @PutMapping("/")
    public int updateGroupeTache(@RequestBody GroupeTache groupeTache) {
        return groupeTacheService.updateGroupeTache(groupeTache);
    }

    @PostMapping("/search")
    public List<GroupeTache> search(@RequestBody GroupeTacheVO groupeTacheVO) {
        return groupeTacheService.search(groupeTacheVO);
    }

}
