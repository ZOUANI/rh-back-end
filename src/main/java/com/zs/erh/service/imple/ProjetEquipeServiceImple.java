package com.zs.erh.service.imple;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;
import com.zs.erh.dao.ProjetEquipeDao;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.ProjetEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetEquipeServiceImple implements ProjetEquipeService {

    public List<ProjetEquipe> findByProjetId(Long id) {
        return projetEquipeDao.findByProjetId(id);
    }

    public List<ProjetEquipe> findByProjetIdAndEquipeAgenceChefAgenceId(Long projetId, Long chefId) {
        return projetEquipeDao.findByProjetIdAndEquipeAgenceChefAgenceId(projetId, chefId);
    }

    public List<ProjetEquipe> findByProjetClientIdAndEquipeResponsableCode(Long id, String code) {
        return projetEquipeDao.findByProjetClientIdAndEquipeResponsableCode(id, code);
    }

    public List<ProjetEquipe> findByEquipeResponsableCode(String code) {
        return projetEquipeDao.findByEquipeResponsableCode(code);
    }

    public int save(Projet projet, List<ProjetEquipe> projetEquipes) {
        for (ProjetEquipe projetEquipe : projetEquipes) {
            projetEquipe.setProjet(projet);
            if (projetEquipe.getEquipe() != null && projetEquipe.getEquipe().getCode() != null) {
                projetEquipe.setEquipe(equipeService.findByCode(projetEquipe.getEquipe().getCode()));
            }
            projetEquipeDao.save(projetEquipe);
        }
        return 1;
    }

    public ProjetEquipe saveDirect(ProjetEquipe projetEquipe) {
        if (projetEquipe.getEquipe() != null && projetEquipe.getEquipe().getCode() != null) {
            projetEquipe.setEquipe(equipeService.findByCode(projetEquipe.getEquipe().getCode()));
        }
        projetEquipeDao.save(projetEquipe);
        return projetEquipe;
    }

    public List<Projet> findProjetsByChefEquipeId(Long chefEquipeId) {
        return projetEquipeDao.findProjetsByChefEquipeId(chefEquipeId);
    }

    public List<Projet> findProjetsByClientIdAndChefEquipeId(Long clientId, Long chefEquipeId) {
        return projetEquipeDao.findProjetsByClientIdAndChefEquipeId(clientId, chefEquipeId);
    }

    public List<ProjetEquipe> findByProjetCode(String code) {
        return projetEquipeDao.findByProjetCode(code);
    }

    public int deleteByProjetCode(String code) {
        return projetEquipeDao.deleteByProjetCode(code);
    }

    public List<ProjetEquipe> findAll() {
        return projetEquipeDao.findAll();
    }


    public void deleteById(Long id) {
        projetEquipeDao.deleteById(id);
    }

    @Autowired
    ProjetEquipeDao projetEquipeDao;
    @Autowired
    EquipeService equipeService;
}
