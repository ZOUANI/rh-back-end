package com.zs.erh.dao;

import com.zs.erh.bean.EtatPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EtatPaiementDao extends JpaRepository<EtatPaiement, Long> {
    public List<EtatPaiement> findAll();
    public EtatPaiement findByCode(String code);
    public int deleteByCode(String code);
}
