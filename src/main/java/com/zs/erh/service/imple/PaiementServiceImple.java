package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.bean.Paiement;
import com.zs.erh.dao.PaiementDao;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.facade.PaiementService;
import com.zs.erh.service.vo.PaiementVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PaiementServiceImple extends AbstractFacade<Paiement> implements PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private FactureService factureService;
    @Autowired
    private EntityManager entityManager;


    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public List<Paiement> findByFactureCode(String code) {
        return paiementDao.findByFactureCode(code);
    }

    public BigDecimal totalPaye(Long factureId) {
        return paiementDao.totalPaye(factureId);
    }

    public BigDecimal totalNonPaye(Paiement paiement) {
        BigDecimal totalPaye = paiementDao.totalPaye(paiement.getFacture().getId());
        if (totalPaye == null){
            return paiement.getFacture().getMontantFacture();
        }else {
            return paiement.getFacture().getMontantFacture().subtract(totalPaye);
        }
    }

    public Paiement save(Paiement paiement) {
        if (findByReference(paiement.getReference()) != null) {
            return null;
        } else {
            Facture facture = factureService.findByCode(paiement.getFacture().getCode());
            if (facture == null) {
                return null;
            } else {
                BigDecimal totalNonPaye = totalNonPaye(paiement);
                if (paiement.getMontant().compareTo(totalNonPaye) > 0){
                    return null;
                }
                else {
                    paiement.setFacture(facture);
                    paiementDao.save(paiement);
                    return paiement;
                }
            }
        }
    }

    public int updatePaiement(Paiement paiement) {
        Paiement p = findByReference(paiement.getReference());
        p.setReference(paiement.getReference());
        p.setLibelle(paiement.getLibelle());
        p.setDescription(paiement.getDescription());
        p.setMontant(paiement.getMontant());
        p.setEtatPaiement(paiement.getEtatPaiement());
        p.setDatePaiement(paiement.getDatePaiement());
        p.setTypePaiement(paiement.getTypePaiement());

        paiementDao.save(p);
        return 1;
    }

    @Transactional
    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }

    @Transactional
    public int deleteByFactureCode(String code) {
        return paiementDao.deleteByFactureCode(code);
    }

    @Transactional
    public int deleteMultiple(List<Paiement> paiements) {
        int res = 0;
        for (int i = 0; i < paiements.size(); i++) {
            res += deleteByReference(paiements.get(i).getReference());
        }
        return res;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Paiement> getEntityClass() {
        return Paiement.class;
    }

    public PaiementVO calcStatistiquePaiement(PaiementVO paiementVO) {
        String query = "SELECT new com.zs.erh.service.vo.PaiementVO(SUM (p.montant), COUNT(p)) FROM Paiement p WHERE 1=1";
        query += addCriteria(paiementVO);
        System.out.println("query = " + query);
        PaiementVO res = (PaiementVO) getEntityManager().createQuery(query).getSingleResult();
        System.out.println("res = " + res);
        return res;
    }

    public String addCriteria(PaiementVO paiementVO) {
        String query = "";
        query += addConstraintMinMaxDate("p", "datePaiement", paiementVO.getDateMin(), paiementVO.getDateMax());
        query += addConstraint("p.facture.agence.chefAgence.id", paiementVO.getChefAgenceId());
        return query;
    }

}
