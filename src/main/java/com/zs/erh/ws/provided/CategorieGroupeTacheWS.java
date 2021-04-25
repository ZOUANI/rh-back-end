package com.zs.erh.ws.provided;

import com.zs.erh.bean.CategorieGroupeTache;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/categorieGroupeTache")
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
}
