package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Facture;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.vo.FactureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/facture")
public class FactureCARest {
    @Autowired
    private FactureService factureService;

    @PostMapping("/statistic-facture")
    public FactureVO calcStatistiqueFacture(@RequestBody FactureVO factureVO) {
        return factureService.calcStatistiqueFacture(factureVO);
    }

    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @GetMapping("/codeChefAgence/{code}")
    public List<Facture> findByAgenceChefAgenceCode(@PathVariable String code) {
        return factureService.findByAgenceChefAgenceCode(code);
    }

    @GetMapping("/code/{code}")
    public Facture findByCode(@PathVariable String code) {
        return factureService.findByCode(code);
    }

    @PostMapping("/")
    public Facture save(@RequestBody Facture facture) {
        return factureService.save(facture);
    }

    @GetMapping("/client/code/{code}")
    public List<Facture> findByClientCode(@PathVariable String code) {
        return factureService.findByClientCode(code);
    }

    @PutMapping("/")
    public int updateFacture(@RequestBody Facture facture) {
        return factureService.updateFacture(facture);
    }

    @PostMapping("/search")
    public List<Facture> search(@RequestBody FactureVO factureVO) {
        return factureService.search(factureVO);
    }
    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Facture> factures) {
        return factureService.deleteMultiple(factures);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return factureService.deleteByCode(code);
    }


}
