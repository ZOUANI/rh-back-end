package com.zs.erh.dao;

import com.zs.erh.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    public List<Paiement> findAll();
    public Paiement findByReference(String reference);
    public List<Paiement> findByFactureCode(String code);
    public int deleteByReference(String reference);
    public int deleteByFactureCode(String code);
}
