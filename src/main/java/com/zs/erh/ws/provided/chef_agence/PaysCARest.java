package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Pays;
import com.zs.erh.service.facade.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/chef-agence/pays")
public class PaysCARest {
    @Autowired
    private PaysService paysService;

    @GetMapping("/code/{code}")
    public Pays findByCode(@PathVariable String code) {
        return paysService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<Pays> findById(@PathVariable Long id) {
        return paysService.findById(id);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return paysService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Pays> findAll() {
        return paysService.findAll();
    }
    @PostMapping("/")
    public Pays save(@RequestBody Pays pays) {
        return paysService.save(pays);
    }
    @PutMapping("/")
    public Pays update(@RequestBody Pays pays) {
        return paysService.update(pays);
    }
}
