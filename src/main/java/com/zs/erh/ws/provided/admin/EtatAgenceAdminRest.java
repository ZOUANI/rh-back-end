package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatAgence;
import com.zs.erh.service.facade.EtatAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/admin/etat-agence")
public class EtatAgenceAdminRest {
    @Autowired
    private EtatAgenceService etatAgenceService;

    @GetMapping("/code/{code}")
    public EtatAgence findByCode(@PathVariable String code) {
        return etatAgenceService.findByCode(code);
    }
    @GetMapping("/id/{id}")
    public Optional<EtatAgence> findById(@PathVariable Long id) {
        return etatAgenceService.findById(id);
    }
    @GetMapping("/")
    public List<EtatAgence> findAll() {
        return etatAgenceService.findAll();
    }
}
