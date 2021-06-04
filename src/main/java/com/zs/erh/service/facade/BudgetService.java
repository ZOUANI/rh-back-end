package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
    Budget findByCode (String code);
    List<Budget> findByEtatBudgetLibelle(String libelle);
    public int deleteByCode(String code);
    public int deleteMultiple(List<Tache> taches);
    public Budget save (Budget budget);
}
