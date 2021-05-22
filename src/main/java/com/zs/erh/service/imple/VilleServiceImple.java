package com.zs.erh.service.imple;

import com.zs.erh.bean.Pays;
import com.zs.erh.bean.Ville;
import com.zs.erh.dao.VilleDao;
import com.zs.erh.service.facade.PaysService;
import com.zs.erh.service.facade.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VilleServiceImple implements VilleService {
    @Autowired
    private VilleDao villeDao;
    @Autowired
    private PaysService paysService;



    @Override
    public List<Ville> findByPaysCode(String code) {
        return villeDao.findByPaysCode(code);
    }
    public Ville findByCode(String code) {
        return villeDao.findByCode(code);
    }

    public Optional<Ville> findById(Long id) {
        return villeDao.findById(id);
    }
    @Transactional
    public int deleteByCode(String code) {
        return villeDao.deleteByCode(code);
    }

    public List<Ville> findAll() {
        return villeDao.findAll();
    }

    public Ville save(Ville ville){
        if(findByCode(ville.getCode())!= null){
            return  null;
        }else{
            Pays pays1 = paysService.findByCode(ville.getPays().getCode());
            if(pays1 == null){
                return  null;
            }else {
                ville.setPays(pays1);
                villeDao.save(ville);
                return  ville;
            }
        }
    }
    public  Ville update(Ville ville){
       Optional<Ville>  ville1 = findById(ville.getId());
       if(ville1.isPresent()){
           Pays pays = paysService.findByCode(ville.getPays().getCode());
           if (pays !=null){
               ville1.get().setPays(pays);
               ville1.get().setCode(pays.getCode());
               ville1.get().setLibelle(pays.getLibelle());
               villeDao.save(ville1.get());
               return  ville1.get();
           }else {
               return  null;
           }
       }else {
           return  null;
       }
    }



}
