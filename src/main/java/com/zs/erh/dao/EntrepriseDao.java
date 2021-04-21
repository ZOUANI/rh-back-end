package com.zs.erh.dao;

import com.zs.erh.bean.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise,Long> {
    Entreprise findByLibelle (String libelle);
    List<Entreprise> findByLibelleLikeAndCodeLike(String libelle,String code);
    int deleteByLibelle ( String libelle);
}

