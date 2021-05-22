package com.zs.erh.dao;

import com.zs.erh.bean.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VilleDao extends JpaRepository<Ville, Long> {
    Ville findByCode(String code);
    Optional<Ville> findById(Long id);
    int deleteByCode(String code);
    List<Ville> findByPaysCode(String code);
}
