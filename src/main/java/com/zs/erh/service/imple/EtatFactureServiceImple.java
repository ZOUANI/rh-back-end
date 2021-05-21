package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatFacture;
import com.zs.erh.dao.EtatFactureDao;
import com.zs.erh.service.facade.EtatFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class EtatFactureServiceImple extends AbstractFacade<EtatFacture> implements EtatFactureService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private EtatFactureDao etatFactureDao;


    public List<EtatFacture> findAll() {
        return etatFactureDao.findAll();
    }

    public EtatFacture findByCode(String code) {
        return etatFactureDao.findByCode(code);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<EtatFacture> getEntityClass() {
        return EtatFacture.class;
    }

}