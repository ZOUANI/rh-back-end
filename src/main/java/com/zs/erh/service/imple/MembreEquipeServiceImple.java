package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Equipe;
import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.dao.EquipeDao;
import com.zs.erh.dao.MembreEquipeDao;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MembreEquipeServiceImple implements MembreEquipeService {
    @Autowired
    private MembreEquipeDao membreEquipeDao;
    @Autowired
    private EquipeService equipeService;
    @Autowired
    private CollaborateurService collaborateurService;

    public List<MembreEquipe> findByCollaborateurCode(String code) {
        return membreEquipeDao.findByCollaborateurCode(code);
    }

    public List<MembreEquipe> findByEquipeCode(String code) {
        return membreEquipeDao.findByEquipeCode(code);
    }

    public int deleteByEquipeCode(String code) {
        return membreEquipeDao.deleteByEquipeCode(code);
    }

    public List<MembreEquipe> findAll() {
        return membreEquipeDao.findAll();
    }

    @Transactional
    public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur) {
        return membreEquipeDao.deleteByEquipeCodeAndCollaborateurCode(codeEquipe, codeCollaborateur);
    }

    public int save(MembreEquipe membreEquipe) {
        if (membreEquipeDao.findById(membreEquipe.getId()).get() != null) {
            return -1;
        } else {
            Equipe equipeFounded = equipeService.findByCode(membreEquipe.getEquipe().getCode());
            Collaborateur collaborateurFounded = collaborateurService.findByCode(membreEquipe.getCollaborateur().getCode());

            if (equipeFounded == null) {
                return -2;
            } else if (collaborateurFounded == null) {
                return -3;
            } else {
                membreEquipe.setEquipe(equipeFounded);
                membreEquipe.setCollaborateur(collaborateurFounded);
                membreEquipeDao.save(membreEquipe);
            }
            return 1;
        }
    }
    public int update(long id, MembreEquipe membreEquipe){
         Optional<MembreEquipe> membreEquipeFounded = membreEquipeDao.findById(id);
         if(membreEquipeFounded.isPresent()){
             membreEquipeFounded.get().setCollaborateur(membreEquipe.getCollaborateur());
             membreEquipeDao.save(membreEquipeFounded.get());
             return 1;
         }else return -1;

    }
}
