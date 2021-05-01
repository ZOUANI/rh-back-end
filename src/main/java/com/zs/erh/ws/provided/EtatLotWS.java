package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatLot;
import com.zs.erh.service.facade.EtatLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/etatlot")
public class EtatLotWS {
    @Autowired
    private EtatLotService etatLotService;

    @GetMapping("/")
    public List<EtatLot> findAll() {
        return etatLotService.findAll();
    }
}
