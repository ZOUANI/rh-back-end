package com.zs.erh.service.imple;

import com.zs.erh.bean.Facture;
import com.zs.erh.bean.Paiement;
import com.zs.erh.dao.PaiementDao;
import com.zs.erh.service.facade.FactureService;
import com.zs.erh.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Paiement findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public List<Paiement> findByFactureCode(String code) {
        return paiementDao.findByFactureCode(code);
    }

    public int save(Paiement paiement) {
        if(findByCode(paiement.getCode())!=null) {
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
        Paiement p = findByCode(paiement.getCode());
        p.setCode(paiement.getCode());
        p.setLibelle(paiement.getLibelle());
        p.setDescription(paiement.getDescription());
        p.setReference(paiement.getReference());
        p.setMontant(paiement.getMontant());
        p.setEtatPaiement(paiement.getEtatPaiement());
        p.setDatePaiement(paiement.getDatePaiement());
        p.setTypePaiement(paiement.getTypePaiement());

        paiementDao.save(p);
        return 1;
    }

    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }
}
