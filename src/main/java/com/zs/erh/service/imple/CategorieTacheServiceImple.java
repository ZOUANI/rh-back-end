package com.zs.erh.service.imple;

import com.zs.erh.bean.CategorieGroupeTache;
import com.zs.erh.bean.CategorieTache;
import com.zs.erh.bean.Client;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.CategorieTacheDao;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import com.zs.erh.service.facade.CategorieTacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieTacheServiceImple implements CategorieTacheService {
    @Autowired
    private CategorieTacheDao categorieTacheDao;
    @Autowired
    private CategorieGroupeTacheService categorieGroupeTacheService;

    public List<CategorieTache> findAll() {
        return categorieTacheDao.findAll();
    }

    public CategorieTache findByCode(String code) {
        return categorieTacheDao.findByCode(code);
    }

    public List<CategorieTache> findByCategorieGroupeTacheCode(String code) {
        return categorieTacheDao.findByCategorieGroupeTacheCode(code);
    }
    @Transactional
    public int deleteByCode(String code) {
        return categorieTacheDao.deleteByCode(code);
    }
    @Transactional
    public int deleteByCategorieGroupeTacheCode(String code) {
        return categorieTacheDao.deleteByCategorieGroupeTacheCode(code);
    }

    public CategorieTache save(CategorieTache categorieTache){
        if(findByCode(categorieTache.getCode())!=null) {
            return null;
        }else{
            CategorieGroupeTache categorieGroupeTache = categorieGroupeTacheService.findByCode(categorieTache.getCategorieGroupeTache().getCode());
            if(categorieGroupeTache==null){
                return null;
            }else {
                categorieTache.setCategorieGroupeTache(categorieGroupeTache);
                categorieTacheDao.save(categorieTache);
                return categorieTache;
            }
        }
    }


    public CategorieTache update(CategorieTache categorieTache){
        CategorieTache categorieTache1 = findByCode( categorieTache.getCode());
        Optional<CategorieGroupeTache> categorieGroupeTache = categorieGroupeTacheService.findById(categorieTache.getCategorieGroupeTache().getId());
        if(categorieGroupeTache.isPresent()){
            categorieTache1.setCategorieGroupeTache(categorieTache.getCategorieGroupeTache());
            categorieTache1.setLibelle(categorieTache.getLibelle());
            categorieTache1.setDescription(categorieTache.getDescription());
            categorieTacheDao.save(categorieTache1);
            return categorieTache1;
        }else {
            return null;
        }
    }

    @Transactional
    public int deleteByCode(List<CategorieTache> categorieTaches) {
        int res=0;
        for (int i = 0; i < categorieTaches.size(); i++) {
            res+=deleteByCode(categorieTaches.get(i).getCode());
        }
        return res;
    }
}
