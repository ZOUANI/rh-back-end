package com.zs.erh.dao;

import com.zs.erh.bean.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise,Long> {
    Entreprise findByCode(String code);
    Optional<Entreprise> findById(Long id);
    List<Entreprise> findByCodeLikeAndLibelleLike(String code,String libelle);
    int deleteByCode ( String code);

}


