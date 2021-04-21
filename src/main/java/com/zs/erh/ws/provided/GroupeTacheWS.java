package com.zs.erh.ws.provided;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.service.facade.GroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/groupeTache")
public class GroupeTacheWS {
    @Autowired
    private GroupeTacheService groupeTacheService;

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
    public int save(@RequestBody GroupeTache groupeTache) {
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

}