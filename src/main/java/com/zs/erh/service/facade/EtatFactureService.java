package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatFacture;

import java.util.List;

public interface EtatFactureService {
    public List<EtatFacture> findAll();
    public EtatFacture findByCode(String code);
}
