package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatTache;

import java.util.List;

public interface EtatTacheService {
    public List<EtatTache> findAll();
    public EtatTache findByCode(String code);
}
