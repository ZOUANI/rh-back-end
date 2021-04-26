package com.zs.erh.service.imple;

import com.zs.erh.bean.CategorieGroupeTache;
import com.zs.erh.dao.CategorieGroupeTacheDao;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieGroupeTacheServiceImple implements CategorieGroupeTacheService {
    @Autowired
    private CategorieGroupeTacheDao categorieGroupeTacheDao;

    public List<CategorieGroupeTache> findAll() {
        return categorieGroupeTacheDao.findAll();
    }

    public CategorieGroupeTache findByCode(String code) {
        return categorieGroupeTacheDao.findByCode(code);
    }
}
