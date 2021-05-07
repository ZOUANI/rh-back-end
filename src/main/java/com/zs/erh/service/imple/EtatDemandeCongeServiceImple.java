package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatDemandeConge;
import com.zs.erh.dao.EtatDemandeCongeDao;
import com.zs.erh.service.facade.EtatDemandeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org .springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EtatDemandeCongeServiceImple implements EtatDemandeCongeService {
    public EtatDemandeConge findByCode(String code) {
        return etatDemandeCongeDao.findByCode(code);
    }

    public List<EtatDemandeConge> findAll() {
        return etatDemandeCongeDao.findAll();
    }


    @Override
    public Optional<EtatDemandeConge> findById(Long id) {
        return etatDemandeCongeDao.findById(id);
    }

    @Autowired
    private EtatDemandeCongeDao etatDemandeCongeDao;
}
