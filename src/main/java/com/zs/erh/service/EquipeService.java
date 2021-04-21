package com.zs.erh.service;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Equipe;
import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.dao.EquipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EquipeService {
    @Autowired
    private EquipeDao equipeDao;

    public List<Equipe> findAll(){
        return equipeDao.findAll();
    }

    public Equipe findByCode(String code){
        return equipeDao.findByCode(code);
    }

    public Equipe findByResponsableCode(String code){
        return equipeDao.findByResponsableCode(code);
    }

    public List<Equipe> findByEtatEquipeCode(String code){
        return equipeDao.findByEtatEquipeCode(code);
    }
   // @Transactional
    public int deleteByCode(String code){
        if(equipeDao.findByCode(code)==null){
            return -1;
        }else{
            //delete Equipe with its membersEquipe
        }
    }

    public int save(Equipe equipe){
        if(equipeDao.findByCode(equipe.getCode())!=null){
            return -1; // already exist !
        }/*else{
            Collaborateur responsable = collaborateurService.findByCode(equipe.getResponsable().getCode());
            EtatEquipe etatequipe  = etatEquipeService.findByCode(equipe.getEtatEquipe().getCode());

            if(responsable == null) {
                return -2;
            }
            else if(etatequipe == null){
                return -3;
            }
            else {
                equipe.setResponsable(responsable);
                equipe.setEtatEquipe(etatequipe);
                equipeDao.save(equipe);
            }*/
            return 1;
        }
 }
}
