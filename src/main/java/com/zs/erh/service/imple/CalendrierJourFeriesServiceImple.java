package com.zs.erh.service.imple;

import com.zs.erh.bean.CalendrierJourFeries;
import com.zs.erh.dao.CalendrierJourFeriesDao;
import com.zs.erh.service.facade.CalendrierJourFeriesService;
import com.zs.erh.service.util.DateUtil;
import com.zs.erh.service.vo.JourFerieVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalendrierJourFeriesServiceImple extends AbstractFacade<CalendrierJourFeries> implements CalendrierJourFeriesService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private CalendrierJourFeriesDao calendrierJourFeriesDao;



    public List<CalendrierJourFeries> findAll() {
        return calendrierJourFeriesDao.findAll();
    }

    public Long calcNombreJourTotal(Date dateDebut, Date dateFin) {
        List<JourFerieVo> res = findByDateMinAndMax(dateDebut, dateFin);
        Long sum = 0L;
        for (JourFerieVo jourFerieVo : res) {
            sum += jourFerieVo.getNbrJour();
        }
        return sum;
    }

    public List<JourFerieVo> findByDateMinAndMax(Date dateDebut, Date dateFin) {
        List<CalendrierJourFeries> calendrierJourFerieses = findAll();
        List<JourFerieVo> res = new ArrayList();
        if (calendrierJourFerieses != null) {
            for (CalendrierJourFeries jf : calendrierJourFerieses) {
                if (jf.getDateFin().getTime() < dateFin.getTime() || jf.getDateDepart().getTime() > dateDebut.getTime()) {
                    Date dateMax = jf.getDateFin();
                    Date dateMin = jf.getDateDepart();
                    if (jf.getDateDepart().getTime() < dateDebut.getTime()) {
                        dateMin = dateDebut;
                    }
                    if (dateFin.getTime() < jf.getDateFin().getTime()) {
                        dateMax = dateFin;
                    }
                    JourFerieVo jfv = new JourFerieVo(jf.getDateDepart(), jf.getDateFin(), DateUtil.diffDays(dateMin, dateMax)-1);
                    res.add(jfv);
                }
            }
        }
        return res;
    }




    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
	public Class<CalendrierJourFeries> getEntityClass() {
		return CalendrierJourFeries.class;
	}

}
