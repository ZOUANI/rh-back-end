package com.zs.erh.dao;

import com.zs.erh.bean.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceDao extends JpaRepository<Agence,Long> {
    Agence findByCode(String code);
    Optional<Agence> findById(Long id);
    List<Agence> findByEtatAgenceCode(String code);
    List<Agence> findByVilleCode(String code);
    int deleteByCode(String code);
}
