package com.zs.erh.ws.provided;

import com.zs.erh.bean.CategorieTache;
import com.zs.erh.service.facade.CategorieTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/categorie-tache")
public class CategorieTacheWS {
    @Autowired
    private CategorieTacheService categorieTacheService;
    @GetMapping("/")
    public List<CategorieTache> findAll() {
        return categorieTacheService.findAll();
    }
    @GetMapping("/code/{code}")
    public CategorieTache findByCode(@PathVariable String code) {
        return categorieTacheService.findByCode(code);
    }
    @GetMapping("/codec/{codec}")
    public List<CategorieTache> findByCategorieGroupeTacheCode(@PathVariable String codec) {
        return categorieTacheService.findByCategorieGroupeTacheCode(codec);
    }
   @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieTacheService.deleteByCode(code);
    }

   @PostMapping("/")
    public CategorieTache save(@RequestBody CategorieTache categorieTache) {
        return categorieTacheService.save(categorieTache);
    }
    @PutMapping("/")
    public CategorieTache update(@RequestBody CategorieTache categorieTache) {
        return categorieTacheService.update(categorieTache);
    }
    @PostMapping("/delete-multiple")
    public int deleteByCode(@RequestBody List<CategorieTache> categorieTaches) {
        return categorieTacheService.deleteByCode(categorieTaches);
    }
}
