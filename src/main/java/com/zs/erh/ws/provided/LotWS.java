package com.zs.erh.ws.provided;

import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Sro;
import com.zs.erh.service.facade.LotService;
import com.zs.erh.service.imple.LotServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/lot")
public class LotWS {
    @Autowired
    public LotService lotService;

    @PostMapping("/")
    public int save(@RequestBody Lot lot) {
        return lotService.save(lot);
    }

    @GetMapping("/projet/code/{code}")
    public List<Lot> findByProjetCode(@PathVariable String code) {
        return lotService.findByProjetCode(code);
    }

    @GetMapping("/code/{code}")
    public Lot findByCode(@PathVariable String code) {
        return lotService.findByCode(code);
    }

    @GetMapping("/sro/code/{code}")
    public List<Sro> findBySroCode(@PathVariable String code) {
        return lotService.findBySroCode(code);
    }

    @GetMapping("/")
    public List<Lot> findAll() {
        return lotService.findAll();
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return lotService.deleteByCode(code);
    }

    @DeleteMapping("/projet/code/{code}")
    public int deleteByProjetCode(@PathVariable String code) {
        return lotService.deleteByProjetCode(code);
    }
}
