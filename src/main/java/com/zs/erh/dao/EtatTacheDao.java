package com.zs.erh.dao;

import com.zs.erh.bean.EtatProjet;
import com.zs.erh.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtatTacheDao extends JpaRepository<EtatTache,Long> {
    public List<EtatTache> findAll();
}
