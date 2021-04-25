package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatProjet;
import com.zs.erh.dao.EtatProjetDao;
import com.zs.erh.service.facade.EtatProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtatProjetServiceImple implements EtatProjetService {
    @Autowired
private EtatProjetDao etatProjetDao;

    public List<EtatProjet> findAll() {
        return etatProjetDao.findAll();
    }
}
