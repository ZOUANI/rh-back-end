package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatDemandeConge;

import java.util.List;
import java.util.Optional;

public interface EtatDemandeCongeService {
    EtatDemandeConge findByCode(String code);
    List<EtatDemandeConge> findAll();
    Optional<EtatDemandeConge> findById(Long id);

}
