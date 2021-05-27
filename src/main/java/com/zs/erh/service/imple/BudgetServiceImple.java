package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.EtatBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImple implements BudgetService {

    @Autowired
    private BudgetDao budgetDao;
    @Autowired
    private AgenceService agenceService;
    @Autowired
    private EtatBudgetService etatBudgetService;

    public List<Budget> findAll() {
        return budgetDao.findAll();
    }

    public Budget findByCode(String code) {
        return budgetDao.findByCode(code);
    }

    public List<Budget> findByEtatBudgetLibelle(String libelle) {
        return budgetDao.findByEtatBudgetLibelle(libelle);
    }

   /* public Budget save(Budget budget) {
        budget.setCode(budget.getLibelle());
        if (budgetDao.findByCode(budget.getCode()) != null) {
            return null;
        }
        if (budget.getDateReponse() != null) {
            if(budget.getDateDemmande().compareTo(budget.getDateReponse()) < 0)
                return null;
        }
        else{
            budgetDao.save(budget);
        }
        return budget;
    }*/
    public Budget save(Budget budget) {
        if (budget.getEtatBudget() != null && budget.getAgence() != null)  {
           budget.setDateDemmande(budget.getDateReponse());
           budgetDao.save(budget);
            return budget;
        }else
            return null;

    }
}
