package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.Lot;
import com.zs.erh.service.facade.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/collaborateur/lot")
public class LotCollabRest {
    @Autowired
    public LotService lotService;



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

    @GetMapping("/projet/id/{id}")
    public List<Lot> findByProjetId(@PathVariable Long id) {
        return lotService.findByProjetId(id);
    }

    @GetMapping("/projetId/{id}/responsableCode/{code}")
    public List<Lot> findByProjetIdAndResponsableCode(@PathVariable Long id, @PathVariable String code) {
        return lotService.findByProjetIdAndResponsableCode(id, code);
    }
}
