package com.zs.erh.dao;

import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Sro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottDao extends JpaRepository<Lot, Long> {
    public List<Lot> findByProjetCode(String code);

    public Lot findByCode(String code);

    public List<Sro> findBySroCode(String code);

    public List<Lot> findAll();

    public int deleteByCode(String code);

    public int deleteByProjetCode(String code);
}