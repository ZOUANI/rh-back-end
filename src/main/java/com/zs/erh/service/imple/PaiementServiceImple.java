package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.bean.Paiement;
import com.zs.erh.dao.PaiementDao;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaiementServiceImple implements PaiementService {
    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private FactureService factureService;

    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public List<Paiement> findByFactureCode(String code) {
        return paiementDao.findByFactureCode(code);
    }

    public int save(Paiement paiement) {
        if(findByReference(paiement.getReference())!=null) {
            return -2;
        }else{
            Facture facture = factureService.findByCode(paiement.getFacture().getCode());
            if(facture==null){
                return -1;
            }else {
                paiement.setFacture(facture);
                paiementDao.save(paiement);
                return 1;
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

}
