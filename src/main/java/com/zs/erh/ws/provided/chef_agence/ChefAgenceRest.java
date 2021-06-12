package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.ChefAgence;
import com.zs.erh.service.facade.ChefAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence")
public class ChefAgenceRest {
    @Autowired
    private ChefAgenceService chefAgenceService;
    @GetMapping("/login/{login}")
    public ChefAgence findByLogin(@PathVariable String login) {
        return chefAgenceService.findByLogin(login);
    }

    @PostMapping("/connectionchef")
    public ChefAgence seconnecter(@RequestBody ChefAgence chefAgence) {
        return chefAgenceService.seconnecter(chefAgence);
    }

    @GetMapping("/code{code}")
    public ChefAgence findByCode(@PathVariable String code) {
        return chefAgenceService.findByCode(code);
    }

    @PutMapping("/")
    public ChefAgence update(@RequestBody ChefAgence chefAgence) {
        return chefAgenceService.update(chefAgence);
    }
}
