package com.zs.erh.service.imple;

import com.zs.erh.bean.Agence;
import com.zs.erh.bean.Budget;
import com.zs.erh.bean.EtatBudget;
import com.zs.erh.bean.Tache;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.EtatBudgetService;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.BudgetVO;
import com.zs.erh.service.vo.StatisticVO;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.*;

@Service
public class BudgetServiceImple extends AbstractFacade<Budget> implements BudgetService {

    @Autowired
    private EntityManager entityManager;
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

    public Budget save(BudgetVO budgetVo) {
        Budget budget = new Budget();
        Agence agence = this.agenceService.findById(budgetVo.getAgenceId()).get();
        EtatBudget etatBudget = etatBudgetService.findById(budgetVo.getEtatBudgetId()).get();
        if (agence != null && etatBudget != null) {
            if (budgetVo.getMontant().compareTo(BigDecimal.ZERO) <= 0) {
                return null;
            } else {
                Date now = new Date();
                String code = agence.getLibelle() + now.getHours() + now.getMinutes();
                budget.setCode(code);
                budget.setEtatBudget(etatBudget);
                budget.setAgence(agence);
                budget.setMontant(budgetVo.getMontant());
                budgetDao.save(budget);
                return budget;
            }
        } else {
            return null;
        }
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    @Transactional
    public int deleteByCode(String code) {
        return budgetDao.deleteByCode(code);
    }

    @Transactional
    public int deleteMultiple(List<Tache> taches) {
        int res = 0;
        for (int i = 0; i < taches.size(); i++) {
            res += deleteByCode(taches.get(i).getCode());
        }
        return res;
    }

    public BudgetVO calcStatistiqueBudget(BudgetVO budgetVO) {
        String query = "SELECT new com.zs.erh.service.vo.BudgetVO(SUM (b.montant),COUNT(b)) FROM Budget  b WHERE 1=1";
        query += addCriteria(budgetVO);
        System.out.println("query = " + query);
        BudgetVO res =(BudgetVO) getEntityManager().createQuery(query).getSingleResult();
        System.out.println("res = " + res);
        return res;
    }

    public String addCriteria(BudgetVO budgetVO) {
        String query = "";
        query += addConstraint("b.agence.chefAgence.id", budgetVO.getChefAgenceId());
        query += addConstraint("b.agence.id", budgetVO.getAgenceId());
        query += addConstraint("b.etatBudget.id", budgetVO.getEtatBudgetId());
        query += addConstraintMinMaxDate("b", "dateReponse", budgetVO.getDateMin(), budgetVO.getDateMax());
        return query;
    }
       public List<Budget> search(BudgetVO budgetVO){
           System.out.println("budgetVo = " + budgetVO);
           String query = "SELECT b FROM Budget b WHERE 1=1";
           query += addCriteria(budgetVO);
           query += " ORDER BY b.dateReponse DESC, b.agence.id ASC,b.etatBudget.id ASC";

           System.out.println("query = " + query);
           return findMultipleResult(query);
       }


    public Budget update(Budget budget) {
        System.out.println(budget);
        Optional<Budget> budgetFounded = budgetDao.findById(budget.getId());
        if(budgetFounded.isPresent()){
            Agence agence = this.agenceService.findByCode(budget.getAgence().getCode());
            if(agence == null){
                System.out.println("agence null");
                return null;
            }else{
                if (budget.getMontant().compareTo(BigDecimal.ZERO) <= 0) {
                    return null;
            } else {
                    budgetFounded.get().setAgence(agence);
                    budgetDao.save(budgetFounded.get());
                    return budgetFounded.get();
                }

            }
        } else {
            return null;
        }
    }

    @Override
    public Class<Budget> getEntityClass() {
        return Budget.class;
    }
}
