package com.zs.erh.service.facade;

import com.zs.erh.bean.CategorieGroupeTache;

import java.util.List;
import java.util.Optional;

public interface CategorieGroupeTacheService {
     List<CategorieGroupeTache> findAll();
     CategorieGroupeTache findByCode(String code);
    int deleteByCode(String code);
    CategorieGroupeTache  save(CategorieGroupeTache categorieGroupeTache);
    CategorieGroupeTache update(CategorieGroupeTache categorieGroupeTache);
    Optional<CategorieGroupeTache> findById(Long id);
    int deleteByCode(List<CategorieGroupeTache> categorieGroupeTaches);
}
