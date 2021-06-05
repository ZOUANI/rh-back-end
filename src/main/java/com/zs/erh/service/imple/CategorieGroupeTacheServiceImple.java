package com.zs.erh.service.imple;

import com.zs.erh.bean.CategorieGroupeTache;
import com.zs.erh.bean.CategorieTache;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.CategorieGroupeTacheDao;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import com.zs.erh.service.facade.CategorieTacheService;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieGroupeTacheServiceImple implements CategorieGroupeTacheService {
    @Autowired
    private CategorieGroupeTacheDao categorieGroupeTacheDao;

    @Autowired
    private CategorieTacheService categorieTacheService;


    public Optional<CategorieGroupeTache> findById(Long id) {
        return categorieGroupeTacheDao.findById(id);
    }
    @Override
    public CategorieGroupeTache findByCode(String code) {
        return categorieGroupeTacheDao.findByCode(code);
    }

   @Transactional
    public int deleteByCode(String code) {
        int deleteByCategorieGroupeTacheCode = categorieTacheService.deleteByCategorieGroupeTacheCode(code);
        int deleteByCode = categorieGroupeTacheDao.deleteByCode(code);
        return  deleteByCategorieGroupeTacheCode + deleteByCode;
    }

    @Override
    public List<CategorieGroupeTache> findAll() {
        return categorieGroupeTacheDao.findAll();
    }

    public CategorieGroupeTache  save(CategorieGroupeTache categorieGroupeTache) {
        if(findByCode(categorieGroupeTache.getCode())!=null){
            return  null;
        }else{
            categorieGroupeTacheDao.save(categorieGroupeTache);
            return categorieGroupeTache;
        }

    }
    public CategorieGroupeTache update(CategorieGroupeTache categorieGroupeTache) {
        return categorieGroupeTacheDao.save(categorieGroupeTache);
    }

    @Transactional
    public int deleteByCode(List<CategorieGroupeTache> categorieGroupeTaches) {
        int res=0;
        for (int i = 0; i < categorieGroupeTaches.size(); i++) {
            res+=deleteByCode(categorieGroupeTaches.get(i).getCode());
        }
        return res;
    }
}
