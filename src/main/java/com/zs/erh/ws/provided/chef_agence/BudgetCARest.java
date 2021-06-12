package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.vo.BudgetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/budget")
public class BudgetCARest {
    @Autowired
    private BudgetService budgetService;

    // Read Services
    @GetMapping("/")
    public List<Budget> findAll() {
        return budgetService.findAll();
    }

    @PostMapping("/statistic-budget")
    public BudgetVO calcStatistiqueBudget(@RequestBody BudgetVO budgetVO) {
        return budgetService.calcStatistiqueBudget(budgetVO);
    }

    @GetMapping("/etat-libelle/{libelle}")
    public List<Budget> findByEtatBudgetLibelle(@PathVariable String libelle) {
        return budgetService.findByEtatBudgetLibelle(libelle);
    }

    @PostMapping("/search")
    public List<Budget> search(@RequestBody BudgetVO budgetVO) {
        return budgetService.search(budgetVO);
    }

}
