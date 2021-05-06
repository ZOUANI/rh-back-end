package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Equipe;
import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.bean.MembreEquipe;
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
    private CollaborateurService collaborateurService;
    @Autowired
    private EquipeService equipeService;

    public List<MembreEquipe> findByCollaborateurCode(String code){
        return membreEquipeDao.findByCollaborateurCode(code);
    }

   public List<MembreEquipe> findByEquipeCode(String code){
        return membreEquipeDao.findByEquipeCode(code);
    }
    public int deleteByEquipeCode(String code){
        return membreEquipeDao.deleteByEquipeCode(code);
    }

    public List<MembreEquipe> findAll(){
        return membreEquipeDao.findAll();
    }

    public MembreEquipe findByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur){
        return membreEquipeDao.findByEquipeCodeAndCollaborateurCode(codeEquipe,codeCollaborateur);
    }
    
    @Transactional
    public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe,String codeCollaborateur){
        return membreEquipeDao.deleteByEquipeCodeAndCollaborateurCode(codeEquipe,codeCollaborateur);
    }
    public int save(MembreEquipe membreEquipe){
        if (membreEquipeDao.findByEquipeCodeAndCollaborateurCode(membreEquipe.getEquipe().getCode(),membreEquipe.getCollaborateur().getCode())!=null ){
            return -1; // already exist !
        } else {
            Collaborateur collaborateurFounded = collaborateurService.findByCode(membreEquipe.getCollaborateur().getCode());
            Equipe equipeFounded = equipeService.findByCode(membreEquipe.getEquipe().getCode());

            if (collaborateurFounded == null) {
                return -2;
            } else if (equipeFounded == null) {
                return -3;
            } else {
                membreEquipe.setEquipe(equipeFounded);
                membreEquipe.setCollaborateur(collaborateurFounded);
                membreEquipeDao.save(membreEquipe);
            }
            return 1;
        }
    }
    public int update(Long id,MembreEquipe membreEquipe){
        Optional<MembreEquipe> foundedMembreEquipe = membreEquipeDao.findById(id);
        if (foundedMembreEquipe.isPresent()) {
           foundedMembreEquipe.get().setCollaborateur(membreEquipe.getCollaborateur());
            return 1;
        }else
            return -1;
    }
    public int updateMembre(MembreEquipe membreEquipe){
        Optional<MembreEquipe> foundedMembreEquipe = membreEquipeDao.findById(membreEquipe.getId());
        if (foundedMembreEquipe.isPresent()) {
            foundedMembreEquipe.get().setCollaborateur(membreEquipe.getCollaborateur());
            return 1;
        }else
            return -1;
    }

}
