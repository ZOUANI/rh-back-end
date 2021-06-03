package com.zs.erh.service.facade;

import com.zs.erh.bean.Budget;
import com.zs.erh.service.vo.BudgetVO;

import java.util.List;

public interface BudgetService {
    List<Budget> findAll();
    Budget findByCode (String code);
    List<Budget> findByEtatBudgetLibelle(String libelle);
    //List<Budget> findByEtatBudjetLibelle(String libelle);
    BudgetVO calculStatisticBudget(BudgetVO budgetVO);
    public Budget save (Budget budget);
}
