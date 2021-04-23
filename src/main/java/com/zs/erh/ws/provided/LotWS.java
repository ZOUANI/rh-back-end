package com.zs.erh.ws.provided;

import com.zs.erh.bean.Lot;
import com.zs.erh.service.imple.LotServiceImple;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/lot")
public class LotWS {
    public LotServiceImple lotServiceImple;
@PostMapping("/")
    public int save(@RequestBody Lot lot) {
        return lotServiceImple.save(lot);
    }
@GetMapping("/projet/code/{code}")
    public List<Lot> findByProjetCode(@PathVariable String code) {
        return lotServiceImple.findByProjetCode(code);
    }
    @GetMapping("/code/{code}")
    public Lot findByCode(@PathVariable String code) {
        return lotServiceImple.findByCode(code);
    }
    @GetMapping("/sro/code/{code}")
    public List<Lot> findBySroCode(@PathVariable String code) {
        return lotServiceImple.findBySroCode(code);
    }

    public List<Lot> findAll() {
        return lotServiceImple.findAll();
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return lotServiceImple.deleteByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByProjetCode(@PathVariable String code) {
        return lotServiceImple.deleteByProjetCode(code);
    }
}