package com.zs.erh.dao;

import com.zs.erh.bean.EtatProjet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtatProjetDao extends JpaRepository<EtatProjet, Long> {
    public List<EtatProjet> findAll();
}
