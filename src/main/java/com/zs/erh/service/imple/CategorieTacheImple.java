package com.zs.erh.service.imple;

import com.zs.erh.bean.CategorieTache;
import com.zs.erh.dao.CategorieTacheDao;
import com.zs.erh.service.facade.CategorieTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieTacheImple implements CategorieTacheService {
    @Autowired
    private CategorieTacheDao categorieTacheDao;

    public List<CategorieTache> findAll() {
        return categorieTacheDao.findAll();
    }

    public CategorieTache findByCode(String code) {
        return categorieTacheDao.findByCode(code);
    }


}
