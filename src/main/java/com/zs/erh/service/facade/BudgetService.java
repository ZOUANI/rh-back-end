package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;
import com.zs.erh.service.vo.BudgetVO;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
    Budget findByCode (String code);
    List<Budget> findByEtatBudgetLibelle(String libelle);
    public int deleteByCode(String code);
    public int deleteMultiple(List<Tache> taches);
    public Budget save (Budget budget);
    BudgetVO calcStatistique(BudgetVO budgetVO);
}
