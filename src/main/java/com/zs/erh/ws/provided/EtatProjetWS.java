package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatProjet;
import com.zs.erh.service.imple.EtatProjetServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/etatprojet")
public class EtatProjetWS {
    @Autowired
    private EtatProjetServiceImple etatProjetServiceImple;

    @GetMapping("/")
    public List<EtatProjet> findAll() {
        return etatProjetServiceImple.findAll();
    }
}
