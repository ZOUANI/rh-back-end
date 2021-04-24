package com.zs.erh.ws.provided;

import com.zs.erh.bean.Sro;
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
        return sroServiceImple.findAll();
    }
    @GetMapping("/code/{code}")
    public Sro findByCode(@PathVariable String code) {
        return sroServiceImple.findByCode(code);
    }

    @Autowired
    public SroServiceImple sroServiceImple;
}
