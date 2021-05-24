package com.zs.erh.ws.provided;

import com.zs.erh.bean.Budget;
import com.zs.erh.service.facade.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetWS {
    @Autowired
    private BudgetService budgetService;

    @GetMapping("/")
    public List<Budget> findAll() {
        return budgetService.findAll();
    }

    @GetMapping("/code/{code}")
    public Budget findByCode(@PathVariable String code) {
        return budgetService.findByCode(code);
    }

    @GetMapping("/etat-libelle/{libelle}")
    public List<Budget> findByEtatBudgetLibelle(String libelle) {
        return budgetService.findByEtatBudgetLibelle(libelle);
    }

    @PostMapping("/")
    public Budget save(Budget budget) {
        return budgetService.save(budget);
    }
}
