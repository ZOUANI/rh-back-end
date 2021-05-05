package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Equipe;
import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.dao.EquipeDao;
import com.zs.erh.dao.EtatEquipeDao;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.EtatEquipeService;
import com.zs.erh.service.facade.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EquipeServiceImple implements EquipeService {
    @Autowired
    private EquipeDao equipeDao;
    @Autowired
    private MembreEquipeService membreEquipeService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private CollaborateurDao collaborateurDao;
    @Autowired
    private EtatEquipeService etatEquipeService;
    @Autowired
    private EtatEquipeDao etatEquipeDao;

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
    public void deleteById(long id){
        equipeDao.deleteById(id);
    }

    public int save(Equipe equipe) {
        equipe.setCode(equipe.getLibelle());
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

  public int update(Long id,Equipe equipe){
        Optional<Equipe> foundedEquipe = equipeDao.findById(id);
        if (foundedEquipe.isPresent()) {
                foundedEquipe.get().setLibelle(equipe.getLibelle());
                foundedEquipe.get().setDescription(equipe.getDescription());
                foundedEquipe.get().setResponsable(equipe.getResponsable());
                foundedEquipe.get().setEtatEquipe(equipe.getEtatEquipe());
                equipeDao.save(foundedEquipe.get());
                return 1;
            }else
                return -1;
            }
}

