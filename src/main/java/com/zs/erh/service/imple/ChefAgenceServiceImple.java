package com.zs.erh.service.imple;

import com.zs.erh.bean.ChefAgence;
import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.ChefAgenceDao;
import com.zs.erh.service.facade.ChefAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChefAgenceServiceImple implements ChefAgenceService {
    @Autowired
    private ChefAgenceDao chefAgenceDao;


    public ChefAgence findByCode(String code) {
        return chefAgenceDao.findByCode(code);
    }

    public Optional<ChefAgence> findById(Long id) {
        return chefAgenceDao.findById(id);
    }

    @Transactional
    public int deleteByCode(String code) {
        return chefAgenceDao.deleteByCode(code);
    }

    public List<ChefAgence> findAll() {
        return chefAgenceDao.findAll();
    }

    public ChefAgence  save(ChefAgence chefAgence) {
        if(findByCode(chefAgence.getCode())!= null){
            return  null;
        }else{
           chefAgenceDao.save(chefAgence);
           return chefAgence;

        }
    }

   public ChefAgence update(ChefAgence chefAgence){
     chefAgenceDao.save(chefAgence);
     return chefAgence;
   }


}