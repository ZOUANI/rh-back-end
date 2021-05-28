package com.zs.erh.dao;

import com.zs.erh.bean.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LottDao extends JpaRepository<Lot, Long> {
    public List<Lot> findByProjetCode(String code);

    public List<Lot> findByProjetId(Long id);

    public Lot findByCode(String code);

    public List<Lot> findAll();

    public int deleteByCode(String code);

    public int deleteByProjetCode(String code);

    public Optional<Lot> findById(Long id);
}