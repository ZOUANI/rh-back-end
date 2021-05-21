package com.zs.erh.ws.provided;

import com.zs.erh.service.facade.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "maneo-rh/facture")
public class FactureWS {
    @Autowired
    private FactureService factureService;


}
