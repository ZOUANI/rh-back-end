package com.zs.erh.dao;

import com.zs.erh.bean.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetDao extends JpaRepository<Budget,Long> {
    List<Budget> findAll();
    Budget findByCode (String code);
    //List<Budget> findByEtatBudjetLibelle(String libelle);
    List<Budget> findByEtatBudgetLibelle(String libelle);
}
