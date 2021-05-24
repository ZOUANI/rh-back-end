package com.zs.erh.service.imple;

import com.zs.erh.bean.Admin;
import com.zs.erh.bean.ChefAgence;
import com.zs.erh.dao.ChefAgenceDao;
import com.zs.erh.service.facade.ChefAgenceService;
import com.zs.erh.service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChefAgenceServiceImple implements ChefAgenceService {

    @Autowired
    private ChefAgenceDao chefAgenceDao;

    public ChefAgence findByLogin(String login) {
        return chefAgenceDao.findByLogin(login);
    }

    public ChefAgence seconnecter(ChefAgence chefAgence) {
        ChefAgence foundedChefAgence = this.chefAgenceDao.findByLogin(chefAgence.getLogin());
        if(foundedChefAgence  == null){
            return null;
        }
        else if (!foundedChefAgence.getPassword().equals(chefAgence.getPassword())){
            return null;
        }else{
            return foundedChefAgence;
        }
    }



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
