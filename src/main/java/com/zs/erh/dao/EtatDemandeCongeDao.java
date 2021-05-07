package com.zs.erh.dao;

import com.zs.erh.bean.EtatDemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtatDemandeCongeDao extends JpaRepository<EtatDemandeConge,Long> {
    EtatDemandeConge findByCode(String code);
    Optional<EtatDemandeConge> findById(Long id);
}

