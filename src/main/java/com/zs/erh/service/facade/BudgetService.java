package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;
import com.zs.erh.service.vo.BudgetVO;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
    Budget findByCode (String code);
    List<Budget> findByEtatBudgetLibelle(String libelle);
    int deleteByCode(String code);
    int deleteMultiple(List<Tache> taches);
    Budget save (BudgetVO budgetVO);
    BudgetVO calcStatistiqueBudget(BudgetVO budgetVO);
    List<Budget> search(BudgetVO budgetVO);
    Budget update (Budget budget);
}
