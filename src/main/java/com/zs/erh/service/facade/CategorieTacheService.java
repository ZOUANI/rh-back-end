package com.zs.erh.service.facade;

import com.zs.erh.bean.CategorieGroupeTache;

import java.util.List;

public interface CategorieTacheService {
    public List<CategorieGroupeTache> findAll();
    public CategorieGroupeTache findByCode(String code);
}
