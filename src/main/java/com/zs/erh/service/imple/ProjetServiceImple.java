package com.zs.erh.service.imple;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.Projet;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.dao.ProjetDao;
import com.zs.erh.service.facade.ProjetService;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.ProjetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProjetServiceImple implements ProjetService {

    public int save(Projet projet) {
        if (projetDao.findByCode(projet.getCode()) != null) {
            return -1;
        } else {
            projetDao.save(projet);
            return 1;
        }
    }


    public Projet findId(Long id) {
        return this.projetDao.findId(id);
    }

    public int deleteByNroCode(String code) {
        return projetDao.deleteByCode(code);
    }

    public List<Projet> findByNroCode(String code) {
        return projetDao.findByNroCode(code);
    }

    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    public Projet findByCode(String code) {
        return projetDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        int resultLot = lotServiceImple.deleteByProjetCode(code);
        int resultProjet = projetDao.deleteByCode(code);
        return resultLot + resultProjet;
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
        //  projet1.setEquipe(projet.getEquipe());
        projet1.setLibelle(projet.getLibelle());
        projet1.setNombreJoureHommeEffectif(projet.getNombreJoureHommeEffectif());
        projet1.setNombreJoureHommePrevu(projet.getNombreJoureHommePrevu());
        projet1.setNombreJoureHommeRetard(projet.getNombreJoureHommeRetard());
        //projet1.setNro(projet.getNro());
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
}
