package com.zs.erh.dao;

import com.zs.erh.bean.ProjetEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetEquipeDao extends JpaRepository<ProjetEquipe,Long> {
    List<ProjetEquipe> findByProjetCode(String code);
    int deleteByProjetCode(String code);
}
