package com.zs.erh.ws.provided;

import com.zs.erh.bean.Periode;
import com.zs.erh.service.facade.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("maneo-rh/periode/")
public class PeriodeWS {
    @Autowired
    private PeriodeService periodeService;

    @GetMapping("/")
    public List<Periode> findAll() {
        return periodeService.findAll();
    }
    @GetMapping("/code/{code}")
    public Periode findByCode(String code) {
        return periodeService.findByCode(code);
    }
}
