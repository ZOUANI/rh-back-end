package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Pays;
import com.zs.erh.service.facade.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-equipe/pays")
public class PaysCERest {
    @Autowired
    private PaysService paysService;
    @GetMapping("/code/{code}")
    public Pays findByCode(@PathVariable String code) {
        return paysService.findByCode(code);
    }
    @GetMapping("/")
    public List<Pays> findAll() {
        return paysService.findAll();
    }
}
