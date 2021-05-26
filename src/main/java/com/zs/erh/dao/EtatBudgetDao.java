package com.zs.erh.dao;

import com.zs.erh.bean.EtatBudget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtatBudgetDao extends JpaRepository<EtatBudget,Long> {
    List<EtatBudget> findAll();
    Optional<EtatBudget> findById(Long id);
    EtatBudget findByCode(String code);
    List<EtatBudget> findByLibelle(String libelle);
    int deleteByCode(String code);
}