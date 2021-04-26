package com.zs.erh.dao;

<<<<<<< HEAD
import com.zs.erh.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatTacheDao extends JpaRepository<EtatTache, Long> {
    public List<EtatTache> findAll();
    public EtatTache findByCode(String code);
=======
import com.zs.erh.bean.EtatProjet;
import com.zs.erh.bean.EtatTache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtatTacheDao extends JpaRepository<EtatTache,Long> {
    public List<EtatTache> findAll();
>>>>>>> origin/master
}
