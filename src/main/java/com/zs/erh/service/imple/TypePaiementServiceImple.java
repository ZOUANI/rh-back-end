package com.zs.erh.service.imple;

import com.zs.erh.bean.TypePaiement;
import com.zs.erh.dao.TypePaiementDao;
import com.zs.erh.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypePaiementServiceImple implements TypePaiementService {
    @Autowired
    private TypePaiementDao typePaiementDao;

    public List<TypePaiement> findAll() {
        return typePaiementDao.findAll();
    }

    public TypePaiement findByCode(String code) {
        return typePaiementDao.findByCode(code);
    }

    public TypePaiement findByReference(String reference) {
        return typePaiementDao.findByReference(reference);
    }

    public int deleteByCode(String code) {
        return typePaiementDao.deleteByCode(code);
    }

    public int deleteByReference(String reference) {
        return typePaiementDao.deleteByReference(reference);
    }

}
