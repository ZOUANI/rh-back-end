package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.dao.FactureDao;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.vo.FactureVO;
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

    public List<Facture> search(FactureVO factureVO) {
        String query = "SELECT f FROM Facture f where 1=1";

        if (factureVO.getClientId() != null) {
            query += " AND f.client.id = " + factureVO.getClientId();
        }

        if (factureVO.getEtatFactureId() != null) {
            query += " AND f.etatFacture.id = " + factureVO.getEtatFactureId();
        }
        return entityManager.createQuery(query).getResultList();
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
