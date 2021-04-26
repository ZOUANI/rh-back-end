package com.zs.erh.ws.provided;

import com.zs.erh.bean.Sro;
import com.zs.erh.service.facade.SroService;
import com.zs.erh.service.imple.SroServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/sro")
public class SroWS {
    @GetMapping("/")
    public List<Sro> findAll() {
        return sroService.findAll();
    }
    @GetMapping("/code/{code}")
    public Sro findByCode(@PathVariable String code) {
        return sroService.findByCode(code);
    }

    @Autowired
    public SroService sroService;
}
