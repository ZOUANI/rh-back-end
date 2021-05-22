package com.zs.erh.service.facade;

import com.zs.erh.bean.Ville;

import java.util.List;
import java.util.Optional;

public interface VilleService {
    Ville findByCode(String code);
    Optional<Ville> findById(Long id);
    int deleteByCode(String code);
    List<Ville> findAll();
    List<Ville> findByPaysCode(String code);
    Ville save(Ville ville);
    Ville update(Ville ville);
}
