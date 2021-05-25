package com.zs.erh.dao;

import com.zs.erh.bean.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement, Long> {
    public List<TypePaiement> findAll();
    public TypePaiement findByCode(String code);
    public TypePaiement findByReference(String reference);
    public int deleteByCode(String code);
    public int deleteByReference(String reference);
}
