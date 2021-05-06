package com.zs.erh.dao;

import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Projet;
import com.zs.erh.bean.Sro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottDao extends JpaRepository<Lot, Long> {
    public List<Lot> findByProjetCode(String code);

    public List<Lot> findByProjetId(Long id);

    public Lot findByCode(String code);

    public List<Sro> findBySroCode(String code);

    public List<Lot> findAll();

    public int deleteByCode(String code);

    public int deleteByProjetCode(String code);
    @Query("SELECT l FROM Lot l WHERE l.id = :id")
    Lot findIdLot(@Param("id") Long id);
}