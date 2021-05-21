package com.zs.erh.service.facade;

import com.zs.erh.bean.Pays;

import java.util.List;
import java.util.Optional;

public interface PaysService {
    Pays findByCode(String code);
    Optional<Pays> findById(Long id);
    int deleteByCode(String code);
    List<Pays> findAll();
    Pays save(Pays pays);
    Pays update(Pays pays);
}
