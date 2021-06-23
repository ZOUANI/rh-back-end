package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.dao.EquipeDao;
import com.zs.erh.dao.EtatEquipeDao;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.ClientVO;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
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
    @Autowired
    private AgenceService agenceService;
    @Autowired
    private EntityManager entityManager;

    public List<Equipe> findAll() {
        return equipeDao.findAll();
    }

    public Equipe findByCode(String code) {
        return equipeDao.findByCode(code);
    }


    public List<Equipe> findByResponsable(Long id) {
        return equipeDao.findByResponsable(id);
    }


    public List<Equipe> findByEtatEquipeCode(String code) {
        return equipeDao.findByEtatEquipeCode(code);
    }

    public List<Equipe> findByResponsableCode(String code) {
        return equipeDao.findByResponsableCode(code);
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

    public Equipe save(Equipe equipe) {
       if(findByCode(equipe.getCode())!=null){
           return null;
       }else{
           Collaborateur responsable = collaborateurService.findByCode(equipe.getResponsable().getCode());
           EtatEquipe etatEquipe = etatEquipeService.findByCode(equipe.getEtatEquipe().getCode());
           Agence agence = agenceService.findByCode(equipe.getAgence().getCode());
           if(responsable == null || etatEquipe == null || agence == null){
               return null;
           }else{
               equipe.setResponsable(responsable);
               equipe.setEtatEquipe(etatEquipe);
               equipe.setAgence(agence);
               equipe.setCode(equipe.getLibelle());
               equipeDao.save(equipe);
               MembreEquipe membreResponsable = new MembreEquipe();
               membreResponsable.setEquipe(equipe);
               membreResponsable.setCollaborateur(responsable);
               membreEquipeService.save(membreResponsable);
               return equipe;
           }
       }
    }
    public Equipe update(Equipe equipe){
        Optional<Equipe> equipeFounded = equipeDao.findById(equipe.getId());
        if(equipeFounded.isPresent()){
            Collaborateur responsable = collaborateurService.findByCode(equipe.getResponsable().getCode());
            EtatEquipe etatEquipe = etatEquipeService.findByCode(equipe.getEtatEquipe().getCode());
           // Agence agence = agenceService.findByCode(equipe.getAgence().getCode());
            if (responsable != null && etatEquipe != null){
                equipeFounded.get().setLibelle(equipe.getLibelle());
                equipeFounded.get().setCode(equipe.getLibelle());
                equipeFounded.get().setResponsable(responsable);
                equipeFounded.get().setEtatEquipe(etatEquipe);
               // equipeFounded.get().setAgence(agence);
                equipeDao.save(equipeFounded.get());
                return equipeFounded.get();
            }else {
                return  null;
            }
        }else {
            return  null;
        }
    }

    public List<Equipe> search(EquipeVO equipeVO){
        String query = "SELECT e FROM Equipe e where 1=1";
        if(StringUtil.isNotEmpty(equipeVO.getLibelle())){
            query+=" AND e.libelle LIKE '%" + equipeVO.getLibelle() + "%'";
        } if (equipeVO.getEtatId() != null) {
            query += " AND e.etatEquipe.id = " + equipeVO.getEtatId();
        } if(equipeVO.getResponsableId()!= null ){
            query +=" AND e.responsable.id = " + equipeVO.getResponsableId();
        }
        return  entityManager.createQuery(query).getResultList();
    }

    public  List<Equipe> findByAgenceChefAgenceCode(String code){
        return equipeDao.findByAgenceChefAgenceCode(code);
    }

}

