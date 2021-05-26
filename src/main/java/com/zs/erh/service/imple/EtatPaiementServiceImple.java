package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatPaiement;
import com.zs.erh.dao.EtatPaiementDao;
import com.zs.erh.service.facade.EtatPaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatPaiementServiceImple implements EtatPaiementService {
    @Autowired
    private EtatPaiementDao etatPaiementDao;

    public List<EtatPaiement> findAll() {
        return etatPaiementDao.findAll();
    }

    public EtatPaiement findByCode(String code) {
        return etatPaiementDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return etatPaiementDao.deleteByCode(code);
    }
}
