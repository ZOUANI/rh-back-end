package com.zs.erh.ws.provided;

import com.zs.erh.bean.Facture;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.vo.FactureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/facture")
public class FactureWS {
    @Autowired
    private FactureService factureService;

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @GetMapping("/code/{code}")
    public Facture findByCode(@PathVariable String code) {
        return factureService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    @PutMapping("/")
    public int updateFacture(@RequestBody Facture facture) { return factureService.updateFacture(facture); }

    @PostMapping("/search")
    public List<Facture> search(@RequestBody FactureVO factureVO) {
        return factureService.search(factureVO);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return factureService.deleteByCode(code);
    }

}