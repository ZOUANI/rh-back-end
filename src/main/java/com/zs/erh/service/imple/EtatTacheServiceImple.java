package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatTache;
import com.zs.erh.dao.EtatTacheDao;
import com.zs.erh.service.facade.EtatTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtatTacheServiceImple implements EtatTacheService {

    @Autowired
    private EtatTacheDao etatTacheDao;

    public List<EtatTache> findAll() {
        return etatTacheDao.findAll();
    }

    public EtatTache findByCode(String code) {
        return etatTacheDao.findByCode(code);
    }

}
