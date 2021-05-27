package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatAgence;
import com.zs.erh.dao.EtatAgenceDao;
import com.zs.erh.service.facade.EtatAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatAgenceServiceImple implements EtatAgenceService {
    @Autowired
    private EtatAgenceDao etatAgenceDao;

    public EtatAgence findByCode(String code) {
        return etatAgenceDao.findByCode(code);
    }

    public Optional<EtatAgence> findById(Long id) {
        return etatAgenceDao.findById(id);
    }

    public List<EtatAgence> findAll() {
        return etatAgenceDao.findAll();
    }




}
