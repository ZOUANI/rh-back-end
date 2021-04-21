package com.zs.erh.service.facade;

import com.zs.erh.bean.Projet;

import java.util.List;

public interface ProjetService {
    List<Projet> findAll();
    Projet findByNroCode(String code);
    Projet findByCode(String Code);
    int deleteByCode(String code);
    public int save(Projet projet);
    public int deleteByNroCode(String code);

}
