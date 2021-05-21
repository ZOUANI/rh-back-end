package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatAgence;

import java.util.List;
import java.util.Optional;

public interface EtatAgenceService {
    EtatAgence findByCode(String code);
    Optional<EtatAgence> findById(Long id);
    List<EtatAgence> findAll();
}
