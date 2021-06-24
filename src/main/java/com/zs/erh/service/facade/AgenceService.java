package com.zs.erh.service.facade;

import com.zs.erh.bean.Agence;
import com.zs.erh.service.vo.AgenceVO;

import java.util.List;
import java.util.Optional;

public interface AgenceService {
    Agence findByCode(String code);
    Optional<Agence> findById(Long id);
    List<Agence> findByEtatAgenceCode(String code);
    List<Agence> findByVilleCode(String code);
    Agence findByChefAgenceCode(String code);
    int deleteByCode(String code);
    int deleteByCode(List<Agence> agences);
    List<Agence> findAll();
    Agence save(Agence agence);
    Agence update(Agence agence);
    List<Agence> findByCriteriaConge(AgenceVO agenceVO);
}
