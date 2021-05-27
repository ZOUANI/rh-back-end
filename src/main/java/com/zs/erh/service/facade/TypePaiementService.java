package com.zs.erh.service.facade;

import com.zs.erh.bean.TypePaiement;

import java.util.List;

public interface TypePaiementService {
    public List<TypePaiement> findAll();
    public TypePaiement findByCode(String code);
    public TypePaiement findByReference(String reference);
    public int deleteByCode(String code);
    public int deleteByReference(String reference);
}
