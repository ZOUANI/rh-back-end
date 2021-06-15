package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.bean.Tache;
import com.zs.erh.dao.FactureDao;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.facade.PaiementService;
import com.zs.erh.service.vo.BudgetVO;
import com.zs.erh.service.vo.FactureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class FactureServiceImple extends AbstractFacade<Facture> implements FactureService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FactureDao factureDao;
    @Autowired
    private PaiementService paiementService;


    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    public List<Facture> findByAgenceChefAgenceCode(String code) {
        return factureDao.findByAgenceChefAgenceCode(code);
    }

    public Facture findByCode(String code) {
        return factureDao.findByCode(code);
    }


    public Facture save(Facture facture) {
        if (factureDao.findByCode(facture.getCode()) != null) {
            return null;
        }
        else {
            factureDao.save(facture);
            return facture;
        }
    }

    @Override
    public List<Facture> findByClientCode(String code) {
        return factureDao.findByClientCode(code);
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

    public List<Facture> search(FactureVO factureVO) {
        String query = "SELECT f FROM Facture f where 1=1";
        if (factureVO.getClientId() != null) {
            query += " AND f.client.id = " + factureVO.getClientId();
        }
        if (factureVO.getEtatFactureId() != null) {
            query += " AND f.etatFacture.id = " + factureVO.getEtatFactureId();
        }
        if (factureVO.getDateMin() !=null && factureVO.getDateMax() != null) {
            query += addConstraintMinMaxDate("f", "dateFacture", factureVO.getDateMin(), factureVO.getDateMax());
        }
        return entityManager.createQuery(query).getResultList();
    }

    @Transactional
    public int deleteByCode(String code) {
        int res1 = this.paiementService.deleteByFactureCode(code);
        return res1 + factureDao.deleteByCode(code);
    }

    @Transactional
    public int deleteMultiple(List<Facture> factures) {
        int res = 0;
        for (int i = 0; i < factures.size(); i++) {
            res += deleteByCode(factures.get(i).getCode());
        }
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Facture> getEntityClass() {
        return Facture.class;
    }

    public FactureVO calcStatistiqueFacture(FactureVO factureVO) {
        String query = "SELECT new com.zs.erh.service.vo.FactureVO(SUM (f.montantFacture),COUNT(f)) FROM Facture f WHERE 1=1";
        query += addCriteria(factureVO);
        System.out.println("query = " + query);
        FactureVO res =(FactureVO) getEntityManager().createQuery(query).getSingleResult();
        System.out.println("res = " + res);
        return res;
    }
    public String addCriteria(FactureVO factureVO) {
        String query = "";
        query += addConstraintMinMaxDate("f", "dateFacture", factureVO.getDateMin(), factureVO.getDateMax());
        query += addConstraint("f.agence.chefAgence.login", factureVO.getChefAgenceLogin());
        return query;
    }
}
