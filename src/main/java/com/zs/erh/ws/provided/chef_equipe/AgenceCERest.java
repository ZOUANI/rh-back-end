package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Agence;
import com.zs.erh.service.facade.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-equipe/agence")
public class AgenceCERest {
    @Autowired
    private AgenceService agenceService;

    @GetMapping("/code/{code}")
    public Agence findByCode(@PathVariable String code) {
        return agenceService.findByCode(code);
    }
    @GetMapping("/codee/{codee}")
    public List<Agence> findByEtatAgenceCode(@PathVariable String codee) {
        return agenceService.findByEtatAgenceCode(codee);
    }
    @GetMapping("/codev/{codev}")
    public List<Agence> findByVilleCode(@PathVariable String codev) {
        return agenceService.findByVilleCode(codev);
    }


}
