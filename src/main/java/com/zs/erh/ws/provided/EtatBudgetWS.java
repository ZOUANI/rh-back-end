package com.zs.erh.ws.provided;

import com.zs.erh.bean.EtatBudget;
import com.zs.erh.service.facade.EtatBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etat-budget")
public class EtatBudgetWS {
    @Autowired
    private EtatBudgetService etatBudgetService;

    @GetMapping("/")
    public List<EtatBudget> findAll() {
        return etatBudgetService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<EtatBudget> findById(@PathVariable Long id) {
        return etatBudgetService.findById(id);
    }

    @GetMapping("/code/{code}")
    public EtatBudget findByCode(String code) {
        return etatBudgetService.findByCode(code);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return etatBudgetService.deleteByCode(code);
    }
}
