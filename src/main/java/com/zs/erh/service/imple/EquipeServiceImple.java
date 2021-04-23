package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Equipe;
import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.dao.EquipeDao;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.EtatEquipeService;
import com.zs.erh.service.facade.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EquipeServiceImple implements EquipeService {
    @Autowired
    private EquipeDao equipeDao;
    @Autowired
    private MembreEquipeService membreEquipeService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private EtatEquipeService etatEquipeService;

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }

    public Equipe findByCode(String code) {
        return equipeDao.findByCode(code);
    }

    public Equipe findByResponsableCode(String code) {
        return equipeDao.findByResponsableCode(code);
    }

    public List<Equipe> findByEtatEquipeCode(String code) {
        return equipeDao.findByEtatEquipeCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        if (equipeDao.findByCode(code) == null) {
            return -1;
        } else {
            //delete Equipe with its membersEquipe
            int delByEquipeCode = membreEquipeService.deleteByEquipeCode(code);
            int delByCode = equipeDao.deleteByCode(code);
            return delByEquipeCode + delByCode;

        }
    }

    public int save(Equipe equipe) {
        if (equipeDao.findByCode(equipe.getCode()) != null) {
            return -1; // already exist !
        } else {
            Collaborateur respoFounded = collaborateurService.findByCode(equipe.getResponsable().getCode());
            EtatEquipe etatEquipeFounded = etatEquipeService.findByCode(equipe.getEtatEquipe().getCode());

            if (respoFounded == null) {
                return -2;
            } else if (etatEquipeFounded == null) {
                return -3;
            } else {
                equipe.setResponsable(respoFounded);
                equipe.setEtatEquipe(etatEquipeFounded);
                equipeDao.save(equipe);
            }
            return 1;
        }
    }
}

