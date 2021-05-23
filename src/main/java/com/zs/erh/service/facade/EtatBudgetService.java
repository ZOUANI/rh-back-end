package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatBudget;

import java.util.List;
import java.util.Optional;

public interface EtatBudgetService {
    List<EtatBudget> findAll();
    Optional<EtatBudget> findById(Long id);
    EtatBudget findByCode(String code);
    int deleteByCode(String code);
}
