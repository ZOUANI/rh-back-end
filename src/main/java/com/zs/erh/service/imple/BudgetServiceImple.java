package com.zs.erh.service.imple;

import com.zs.erh.bean.Agence;
import com.zs.erh.bean.Budget;
import com.zs.erh.bean.*;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
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
                return budget;
    }


    public BudgetVO calculStatisticBudget(BudgetVO budgetVO) {
        String query = "SELECT new com.zs.erh.service.vo.BudgetVO (SUM(b.montant) ,COUNT(b)) FROM Budget b WHERE 1=1";
        query += addCriteria(budgetVO);
        System.out.println("query = " + query);
        BudgetVO res =(BudgetVO) getEntityManager().createQuery(query).getSingleResult();
        return res;

    }


    public String addCriteria(BudgetVO budgetVO) {
        String query = "";
        query += addConstraintMinMaxDate("b", "dateReponse", budgetVO.getDateMin(), budgetVO.getDateMax());
        query += addConstraint("b.agence.id", budgetVO.getAgenceId());
        return query;
    }
