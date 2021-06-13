package com.zs.erh.ws.provided.general;

import com.zs.erh.bean.CalendrierJourFeries;
import com.zs.erh.service.facade.CalendrierJourFeriesService;
import com.zs.erh.service.vo.JourFerieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("maneo-rh/general/calendrierJourFeries")
public class CalendrierJourFeriesRest {
    @Autowired
    private CalendrierJourFeriesService calendrierJourFeriesService;

    @GetMapping("/")
    public List<CalendrierJourFeries> findAll() {
        return calendrierJourFeriesService.findAll();
    }

    @GetMapping("/calcNombreJourTotal/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public Long calcNombreJourTotal(@PathVariable Date dateDebut, @PathVariable Date dateFin) {
        return calendrierJourFeriesService.calcNombreJourTotal(dateDebut, dateFin);
    }

    @GetMapping("/dateDebut/{dateDebut}/dateFin/{dateFin}")
    public List<JourFerieVo> findByDateMinAndMax(@PathVariable Date dateDebut, @PathVariable Date dateFin) {
        return calendrierJourFeriesService.findByDateMinAndMax(dateDebut, dateFin);
    }
}
