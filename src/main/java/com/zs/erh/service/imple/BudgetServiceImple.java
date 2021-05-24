package com.zs.erh.service.imple;

import com.zs.erh.bean.Budget;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImple implements BudgetService {

    @Autowired
    private BudgetDao budgetDao;

    public List<Budget> findAll() {
        return budgetDao.findAll();
    }

    public Budget findByCode(String code) {
        return budgetDao.findByCode(code);
    }

   /*public List<Budget> findByEtatBudjetLibelle(String libelle) {
        return budgetDao.findByEtatBudjetLibelle(libelle);
    }*/

    public Budget save(Budget budget) {
        return budget;
    }
}
