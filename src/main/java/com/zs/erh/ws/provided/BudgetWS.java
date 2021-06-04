package com.zs.erh.ws.provided;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Tache;
import com.zs.erh.service.facade.BudgetService;
import com.zs.erh.service.vo.BudgetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "maneo-rh/budget")
public class BudgetWS {
    @Autowired
    private BudgetService budgetService;
    @PostMapping("/statistic-budget")
    public BudgetVO calcStatistique(@RequestBody BudgetVO budgetVO) {
        return budgetService.calcStatistique(budgetVO);
    }

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
    public int deleteByCode(@PathVariable String code) {
        return budgetService.deleteByCode(code);
    }

    @PostMapping("/delete/")
    public int deleteMultiple(@RequestBody List<Tache> taches) {
        return budgetService.deleteMultiple(taches);
    }
}
