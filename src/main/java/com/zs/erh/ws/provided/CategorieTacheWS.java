package com.zs.erh.ws.provided;

import com.zs.erh.bean.CategorieTache;
import com.zs.erh.service.facade.CategorieTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/categorieTache/")
public class CategorieTacheWS {
    @Autowired
    private CategorieTacheService categorieTacheService;

    @GetMapping("/")
    public List<CategorieTache> findAll() {
        return categorieTacheService.findAll();
    }

    @GetMapping("/code/{code}")
    public CategorieTache findByCode(String code) {
        return categorieTacheService.findByCode(code);
    }

}
