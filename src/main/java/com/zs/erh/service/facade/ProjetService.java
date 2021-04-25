package com.zs.erh.service.facade;

import com.zs.erh.bean.Projet;

import java.util.List;

public interface ProjetService {
    List<Projet> findAll();

    List<Projet> findByNroCode(String code);

    Projet findByCode(String Code);

    int deleteByCode(String code);

    int save(Projet projet);

    int deleteByNroCode(String code);

}
