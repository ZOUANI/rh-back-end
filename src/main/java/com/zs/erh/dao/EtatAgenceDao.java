package com.zs.erh.dao;

import com.zs.erh.bean.EtatAgence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtatAgenceDao extends JpaRepository<EtatAgence, Long> {
    EtatAgence findByCode(String code);
    Optional<EtatAgence> findById(Long id);
}
