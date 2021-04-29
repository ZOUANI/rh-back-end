package com.zs.erh.dao;

import com.zs.erh.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatTacheDao extends JpaRepository<EtatTache, Long> {
    public List<EtatTache> findAll();
    public EtatTache findByCode(String code);
}
