package com.zs.erh.service.facade;

import com.zs.erh.bean.CalendrierJourFeries;
import com.zs.erh.service.vo.JourFerieVo;

import java.util.Date;
import java.util.List;

public interface CalendrierJourFeriesService {

    public List<CalendrierJourFeries> findAll();
    public Long calcNombreJourTotal(Date dateDebut, Date dateFin);
    public List<JourFerieVo> findByDateMinAndMax(Date dateDebut, Date dateFin);
}
