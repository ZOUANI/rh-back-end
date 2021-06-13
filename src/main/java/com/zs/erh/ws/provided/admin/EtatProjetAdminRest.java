package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.EtatProjet;
import com.zs.erh.service.facade.EtatProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/admin/etatprojet")
public class EtatProjetAdminRest {
    @Autowired
    private EtatProjetService etatProjetService;

    @GetMapping("/")
    public List<EtatProjet> findAll() {
        return etatProjetService.findAll();
    }
}
