package com.zs.erh.dao;

import com.zs.erh.bean.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaysDao extends JpaRepository<Pays,Long> {
    Pays findByCode(String code);
    Optional<Pays> findById(Long id);
    int deleteByCode(String code);
}
