package com.zs.erh.ws.provided;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/budget")
public class BudgetWS {
    @Autowired
    private BudgetService budgetService;

    @GetMapping("/")
    public List<Budget> findAll() {
        return budgetService.findAll();
    }
    @GetMapping("/code/{code}")
    public Budget findByCode(@PathVariable String code){
        return budgetService.findByCode(code);
    }
    @PostMapping("/")
    public Budget save(@RequestBody Budget budget){
        return budgetService.save(budget);
    }

    @GetMapping("/etat-libelle/{libelle}")
    public List<Budget> findByEtatBudgetLibelle(@PathVariable String libelle) {
        return budgetService.findByEtatBudgetLibelle(libelle);
    }

    @DeleteMapping("/delete/{code}")
    public int deleteByCode(String code) {
        return budgetService.deleteByCode(code);
    }

    @PostMapping("/delete/")
    public int deleteMultiple(List<Tache> taches) {
        return budgetService.deleteMultiple(taches);
    }
}
