package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.BudgetDao;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.facade.EtatBudgetService;
import com.zs.erh.service.vo.BudgetVO;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class BudgetServiceImple extends AbstractFacade<Budget> implements BudgetService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private BudgetDao budgetDao;
    @Autowired
    private EtatBudgetService etatBudgetService;
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

    @Override
    public Class<Budget> getEntityClass() {
        return Budget.class;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}