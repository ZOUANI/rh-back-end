package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatPaiement;

import java.util.List;

public interface EtatPaiementService {
    public List<EtatPaiement> findAll();
    public EtatPaiement findByCode(String code);
    public int deleteByCode(String code);
}
