package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.dao.FactureDao;
import com.zs.erh.service.facade.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class FactureServiceImple extends AbstractFacade<Facture> implements FactureService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FactureDao factureDao;


    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    public Facture findByCode(String code) {
        return factureDao.findByCode(code);
    }

    public int save(Facture facture) {
        if (factureDao.findByCode(facture.getCode()) != null) {
            return -1;
        }
        else {
            factureDao.save(facture);
            return 1;
        }
    }

    public int deleteByCode(String code) {
        return factureDao.deleteByCode(code);
    }

    public int updateFacture(Facture facture) {
        Facture grp = findByCode(facture.getCode());
        grp.setCode(facture.getCode());
        grp.setLibelle(facture.getLibelle());
        grp.setDescription(facture.getDescription());
        grp.setMontantCalcule(facture.getMontantCalcule());
        grp.setTotalHeursCalcules(facture.getTotalHeursCalcules());
        grp.setEtatFacture(facture.getEtatFacture());
        grp.setClient(facture.getClient());
        grp.setMontantFacture(facture.getMontantFacture());
        grp.setTotalHeursFactures(facture.getTotalHeursFactures());
        grp.setEtatFacture(facture.getEtatFacture());

        factureDao.save(grp);
        return 1;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Facture> getEntityClass() {
        return Facture.class;
    }
}
