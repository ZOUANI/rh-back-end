package com.zs.erh.dao;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge,Long> {
    Optional<DemandeConge> findById(Long id);
    List<DemandeConge> findByEtatDemandeCongeCode(String code);
    void deleteById(Long id);
}

