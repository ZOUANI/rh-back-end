package com.zs.erh.ws.provided;

import com.zs.erh.bean.Nro;
import com.zs.erh.service.facade.NroService;
import com.zs.erh.service.imple.NroServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/nro")
public class NroWS {
    @Autowired
    public NroServiceImple nroServiceImple;

    @GetMapping("/")
    public List<Nro> findAll() {
        return nroServiceImple.findAll();
    }

    @GetMapping("/code/{code}/")
    public Nro findByCode(@PathVariable String Code) {
        return nroServiceImple.findByCode(Code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return nroServiceImple.deleteByCode(code);
    }
}
