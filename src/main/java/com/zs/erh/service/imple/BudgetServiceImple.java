package com.zs.erh.service.imple;

import com.zs.erh.bean.Agence;
import com.zs.erh.bean.Budget;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BudgetServiceImple implements BudgetService {

    @Autowired
    private BudgetDao budgetDao;

    @Autowired
    private AgenceService agenceService;

    public List<Budget> findAll() {
        return budgetDao.findAll();
    }

    public Budget findByCode(String code) {
        return budgetDao.findByCode(code);
    }

    public List<Budget> findByEtatBudgetLibelle(String libelle) {
        return budgetDao.findByEtatBudgetLibelle(libelle);
    }
   /*public List<Budget> findByEtatBudjetLibelle(String libelle) {
        return budgetDao.findByEtatBudjetLibelle(libelle);
    }*/

    public Budget save(Budget budget) {
        System.out.println("budget = " + budget);
        Agence agence = this.agenceService.findByCode(budget.getAgence().getCode());
        if (agence != null) {
            if (budget.getMontant().compareTo(BigDecimal.ZERO) <= 0) {
                return null;
            } else {
                Date now = new Date();
                String code = agence.getLibelle() + now.getHours() + now.getMinutes();
                budget.setCode(code);
                budget.setAgence(agence);
                budgetDao.save(budget);
                return budget;
            }
        } else {
            return null;
        }
    }
}
