package com.zs.erh.ws.provided;

import com.zs.erh.bean.CategorieGroupeTache;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/categorie-groupe-tache")
public class CategorieGroupeTacheWS {
    @Autowired
    private CategorieGroupeTacheService categorieGroupeTacheService;
   @GetMapping("/")
    public List<CategorieGroupeTache> findAll() {
        return categorieGroupeTacheService.findAll();
    }
    @GetMapping("/code/{code}")
    public CategorieGroupeTache findByCode(@PathVariable String code) {
        return categorieGroupeTacheService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieGroupeTacheService.deleteByCode(code);
    }
   @PostMapping("/")
    public CategorieGroupeTache save(@RequestBody CategorieGroupeTache categorieGroupeTache) {
        return categorieGroupeTacheService.save(categorieGroupeTache);
    }
    @PutMapping("/")
    public CategorieGroupeTache update(@RequestBody CategorieGroupeTache categorieGroupeTache) {
        return categorieGroupeTacheService.update(categorieGroupeTache);
    }
    @GetMapping("/id/{id}")
    public Optional<CategorieGroupeTache> findById(@PathVariable Long id) {
        return categorieGroupeTacheService.findById(id);
    }
    @PostMapping("/delete-multiple")
    public int deleteByCode(@RequestBody List<CategorieGroupeTache> categorieGroupeTaches) {
        return categorieGroupeTacheService.deleteByCode(categorieGroupeTaches);
    }
}
