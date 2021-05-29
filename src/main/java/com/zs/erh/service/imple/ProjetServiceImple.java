package com.zs.erh.service.imple;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Projet;
import com.zs.erh.dao.*;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProjetServiceImple implements ProjetService {

    public List<Projet> findByClientId(Long id) {
        return projetDao.findByClientId(id);
    }

    public Projet save(Projet projet) {
        if (projetDao.findByCode(projet.getCode()) != null) {
            return null;
        } else {
            projetDao.save(projet);
            projetEquipeService.save(projet,projet.getProjetEquipes());
            return projet;
        }
    }


    public Projet findId(Long id) {
        return this.projetDao.findId(id);
    }

    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    public Projet findByCode(String code) {
        return projetDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        List<Lot> lots=lottDao.findByProjetCode(code);
        for (Lot lot:lots) {
            List<GroupeTache> groupeTaches=groupeTacheDao.findByLotCode(lot.getCode());
            for (GroupeTache groupeTache:groupeTaches) {
                tacheService.deleteByGroupeTacheCode(groupeTache.getCode());
            }
            groupeTacheService.deleteByLotCode(lot.getCode());

        }
        int resultProjetEquipe= projetEquipeService.deleteByProjetCode(code);
        int resultLot = lotServiceImple.deleteByProjetCode(code);
        int resultProjet = projetDao.deleteByCode(code);
        return resultProjetEquipe+resultLot + resultProjet;
    }

    @Transactional
    public int deleteMultiple(List<Projet> projets) {
        int res=0;
        for (int i = 0; i < projets.size(); i++) {
            res+=deleteByCode(projets.get(i).getCode());
        }
        return res;
    }

    public void update(Projet projet) {
        Projet projet1 = projetDao.findId(projet.getId());
        projet1.setCode(projet.getCode());
        projet1.setAvancement(projet.getAvancement());
        projet1.setClient(projet.getClient());
        projet1.setDateDemarrageEffective(projet.getDateDemarrageEffective());
        projet1.setDateDemarragePrevu(projet.getDateDemarragePrevu());
        projet1.setDateFinEffective(projet.getDateFinEffective());
        projet1.setDateFinPrevu(projet.getDateFinPrevu());
        projet1.setDescription(projet.getDescription());
        projet1.setLibelle(projet.getLibelle());
        projet1.setNombreJoureHommeEffectif(projet.getNombreJoureHommeEffectif());
        projet1.setNombreJoureHommePrevu(projet.getNombreJoureHommePrevu());
        projet1.setNombreJoureHommeRetard(projet.getNombreJoureHommeRetard());
        projet1.setResponsable(projet.getResponsable());
        projetDao.save(projet1);
    }

    public List<Projet> search(ProjetVO projetVo) {
        String query = "SELECT p from Projet p WHERE 1=1 ";
        if (StringUtil.isNotEmpty(projetVo.getClientId()))
            query += "AND p.client.id ='" + projetVo.getClientId() + "'";
        if (StringUtil.isNotEmpty(projetVo.getEtatProjetId()))
            query += "AND p.etatProjet.id ='" + projetVo.getEtatProjetId() + "'";
        if (StringUtil.isNotEmpty(projetVo.getLibelleProjet()))
            query += "AND p.libelle ='" + projetVo.getLibelleProjet() + "'";
        if (StringUtil.isNotEmpty(projetVo.getResponsableProjetId()))
            query += "AND p.responsable.id ='" + projetVo.getResponsableProjetId() + "'";
        if (StringUtil.isNotEmpty(projetVo.getNroId()))
            query += "AND p.nro.id ='" + projetVo.getNroId() + "'";

        return entityManager.createQuery(query).getResultList();
    }

    @Autowired
    private EntityManager entityManager;
    @Autowired
    public ProjetDao projetDao;
    @Autowired
    public LotServiceImple lotServiceImple;
    @Autowired
    public ProjetEquipeService projetEquipeService;

    @Autowired
    public LottDao lottDao;
    @Autowired
    public GroupeTacheService groupeTacheService;
    @Autowired
    public GroupeTacheDao groupeTacheDao;
    @Autowired
    public TacheService tacheService;
    @Autowired
    public TacheDao tacheDao;
}
