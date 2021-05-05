package com.zs.erh.service.facade;

import com.zs.erh.bean.CategorieTache;

import java.util.List;

public interface CategorieTacheService {
    public List<CategorieTache> findAll();
    public CategorieTache findByCode(String code);
    public List<CategorieTache> findByCategorieGroupeTacheCode(String code);
}
