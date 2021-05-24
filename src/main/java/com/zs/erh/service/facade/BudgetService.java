package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
    Budget findByCode (String code);
    List<Budget> findByEtatBudgetLibelle(String libelle);

    public Budget save (Budget budget);
}
