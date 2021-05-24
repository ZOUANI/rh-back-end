package com.zs.erh.ws.provided;

import com.zs.erh.bean.Budget;
import com.zs.erh.bean.Collaborateur;
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
    @PostMapping("/")
    public Budget save(@RequestBody Budget budget){
        return budgetService.save(budget);
    }
}
