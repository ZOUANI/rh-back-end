package com.zs.erh.service.facade;

import com.zs.erh.bean.Paiement;

import java.util.List;

public interface PaiementService {
    public List<Paiement> findAll();
    public Paiement findByCode(String code);
    public Paiement findByReference(String reference);
    public int deleteByCode(String code);
    public int deleteByReference(String reference);
}
