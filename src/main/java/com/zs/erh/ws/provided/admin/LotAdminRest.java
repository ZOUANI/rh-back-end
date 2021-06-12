package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Lot;
import com.zs.erh.service.facade.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/lot")
public class LotAdminRest {
    @Autowired
    public LotService lotService;

    @PostMapping("/")
    public Lot save(@RequestBody Lot lot) {
        return lotService.save(lot);
    }

    @PostMapping("/delete-multiple-by-code")
    public int deleteMultiple(@RequestBody List<Lot> lots) {
        return lotService.deleteMultiple(lots);
    }

    @GetMapping("/projet/code/{code}")
    public List<Lot> findByProjetCode(@PathVariable String code) {
        return lotService.findByProjetCode(code);
    }

    @GetMapping("/code/{code}")
    public Lot findByCode(@PathVariable String code) {
        return lotService.findByCode(code);
    }

    @GetMapping("/codeChefAgence/{code}")
    public List<Lot> findByProjetAgenceChefAgenceCode(@PathVariable String code) {
        return lotService.findByProjetAgenceChefAgenceCode(code);
    }

    @GetMapping("/codeResponsable/{code}")
    public List<Lot> findByResponsableCode(@PathVariable String code) {
        return lotService.findByResponsableCode(code);
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

    @PutMapping("/")
    public int updateLot(@RequestBody Lot lot) {
        return lotService.updateLot(lot);
    }

    @GetMapping("/projet/id/{id}")
    public List<Lot> findByProjetId(@PathVariable Long id) {
        return lotService.findByProjetId(id);
    }

    @GetMapping("/projetId/{id}/responsableCode/{code}")
    public List<Lot> findByProjetIdAndResponsableCode(@PathVariable Long id, @PathVariable String code) {
        return lotService.findByProjetIdAndResponsableCode(id, code);
    }
}
