package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.AgenceDao;
import com.zs.erh.service.facade.AgenceService;
import com.zs.erh.service.facade.ChefAgenceService;
import com.zs.erh.service.facade.EtatAgenceService;
import com.zs.erh.service.facade.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AgenceServiceImple implements AgenceService {
    @Autowired
    private AgenceDao agenceDao;

    public Agence findByChefAgenceCode(String code) {
        return agenceDao.findByChefAgenceCode(code);
    }

    @Autowired
    private ChefAgenceService chefAgenceService;
    @Autowired
    private EtatAgenceService etatAgenceService;
    @Autowired
    private VilleService villeService;


    public Agence findByCode(String code) {
        return agenceDao.findByCode(code);
    }

    public Optional<Agence> findById(Long id) {
        return agenceDao.findById(id);
    }


    public List<Agence> findByEtatAgenceCode(String code) {
        return agenceDao.findByEtatAgenceCode(code);
    }

    public List<Agence> findByVilleCode(String code) {
        return agenceDao.findByVilleCode(code);
    }
    @Transactional
    public int deleteByCode(String code) {
        return agenceDao.deleteByCode(code);
    }

    @Transactional
    public int deleteByCode(List<Agence> agences) {
        int res=0;
        for (int i = 0; i < agences.size(); i++) {
            res+=deleteByCode(agences.get(i).getCode());
        }
        return res;
    }


    public List<Agence> findAll() {
        return agenceDao.findAll();
    }

    public Agence save(Agence agence) {
        if (findByCode(agence.getCode()) != null) {
            return null;
        } else {
            ChefAgence chefAgence = chefAgenceService.findByCode(agence.getChefAgence().getCode());
            EtatAgence etatAgence = etatAgenceService.findByCode(agence.getEtatAgence().getCode());
            Ville ville = villeService.findByCode(agence.getVille().getCode());
            if (chefAgence == null || etatAgence == null || ville == null) {
                return null;
            } else {
                agence.setChefAgence(chefAgence);
                agence.setEtatAgence(etatAgence);
                agence.setVille(ville);
                agenceDao.save(agence);
                return agence;
            }
        }
    }
  public Agence update(Agence agence){
        Optional<Agence> agence1 = findById(agence.getId());
        if(agence1.isPresent()){
            ChefAgence chefAgence = chefAgenceService.findByCode(agence.getChefAgence().getCode());
            EtatAgence etatAgence = etatAgenceService.findByCode(agence.getEtatAgence().getCode());
            Ville ville = villeService.findByCode(agence.getVille().getCode());
            if (chefAgence != null && etatAgence != null && ville != null){
                agence1.get().setChefAgence(chefAgence);
                agence1.get().setEtatAgence(etatAgence);
                agence1.get().setVille(ville);
                agence1.get().setCode(agence.getCode());
                agence1.get().setLibelle(agence.getLibelle());
                agenceDao.save(agence1.get());
                return agence1.get();
            }else {
                return  null;
            }
        }else {
            return  null;
        }
  }

}
