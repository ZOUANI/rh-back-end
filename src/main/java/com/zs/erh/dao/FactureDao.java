package com.zs.erh.dao;

import com.zs.erh.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
    public List<Facture> findAll();

    public Facture findByCode(String code);

    public List<Facture> findByClientCode(String code);

    public int deleteByCode(String code);
}
