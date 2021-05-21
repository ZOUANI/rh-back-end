package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.dao.FactureDao;
import com.zs.erh.service.facade.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class FactureServiceImple extends AbstractFacade<Facture> implements FactureService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FactureDao factureDao;





    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Facture> getEntityClass() {
        return Facture.class;
    }
}
