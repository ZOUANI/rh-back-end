package com.zs.erh.service.imple;

import com.zs.erh.bean.Paiement;
import com.zs.erh.dao.PaiementDao;
import com.zs.erh.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementServiceImple implements PaiementService {
    @Autowired
    private PaiementDao paiementDao;

    public List<Paiement> findAll() {
        return paiementDao.findAll();
    }

    public Paiement findByCode(String code) {
        return paiementDao.findByCode(code);
    }

    public Paiement findByReference(String reference) {
        return paiementDao.findByReference(reference);
    }

    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    public int deleteByReference(String reference) {
        return paiementDao.deleteByReference(reference);
    }
}
