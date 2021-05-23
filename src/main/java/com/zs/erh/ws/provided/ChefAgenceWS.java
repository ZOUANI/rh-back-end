package com.zs.erh.ws.provided;

import com.zs.erh.bean.ChefAgence;
import com.zs.erh.service.facade.ChefAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence")
public class ChefAgenceWS {
    @Autowired
    private ChefAgenceService chefAgenceService;
    @GetMapping("/login/{login}")
    public ChefAgence findByLogin(@PathVariable String login) {
        return chefAgenceService.findByLogin(login);
    }

    @GetMapping("/code{code}")
    public ChefAgence findByCode(@PathVariable String code) {
        return chefAgenceService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<ChefAgence> findById(@PathVariable Long id) {
        return chefAgenceService.findById(id);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return chefAgenceService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<ChefAgence> findAll() {
        return chefAgenceService.findAll();
    }
    @PostMapping("/")
    public ChefAgence save(@RequestBody ChefAgence chefAgence) {
        return chefAgenceService.save(chefAgence);
    }
    @PutMapping("/")
    public ChefAgence update(@RequestBody ChefAgence chefAgence) {
        return chefAgenceService.update(chefAgence);
    }
}
