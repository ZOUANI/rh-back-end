package com.zs.erh.ws.provided;

import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "maneo-rh/etatFacture")
public class EtatFactureWS {
    @Autowired
    private EtatTacheService etatTacheService;


}
