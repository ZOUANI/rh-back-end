package com.zs.erh.service.imple;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.dao.GroupeTacheDao;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.vo.GroupeTacheVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Service
public class GroupeTacheServiceImple implements GroupeTacheService {

    @Autowired
    private GroupeTacheDao groupeTacheDao;
    @Autowired
    private TacheService tacheService;

    @Autowired
    private EquipeService equipeService;

    @Autowired
    private LotService lotService;

    @Autowired
    private CategorieGroupeTacheService categorieGroupeTacheService;

    @Autowired
    private EtatGroupeTacheService etatGroupeTacheService;

    @Autowired
    private EntityManager entityManager;

    public List<GroupeTache> findByLotProjetAgenceChefAgenceCode(String code){
        return groupeTacheDao.findByLotProjetAgenceChefAgenceCode(code);
    }

    public List<GroupeTache> findByEquipeResponsableCode(String code) {
        return groupeTacheDao.findByEquipeResponsableCode(code);
    }

    public List<GroupeTache> findByEquipeCode(String code) {
        return groupeTacheDao.findByEquipeCode(code);
    }

    public List<GroupeTache> findAll() {
        return groupeTacheDao.findAll();
    }

    public List<GroupeTache> findByLotCode(String code) {
        return groupeTacheDao.findByLotCode(code);
    }

    public GroupeTache findByCode(String code) {
        return groupeTacheDao.findByCode(code);
    }

    public GroupeTache save(GroupeTache groupeTache) {
        // Si le groupe de tache existe déja
        if (groupeTacheDao.findByCode(groupeTache.getCode()) != null) {
            return null;
        } else {
            groupeTache.setCategorieGroupeTache(categorieGroupeTacheService.findByCode(groupeTache.getCategorieGroupeTache().getCode()));
            groupeTache.setEquipe(equipeService.findByCode(groupeTache.getEquipe().getCode()));
            groupeTache.setLot(lotService.findByCode(groupeTache.getLot().getCode()));
            groupeTacheDao.save(groupeTache);
            return groupeTache;
        }
    }

    @Transactional
    public int deleteByCode(String code) {
        int res1 = this.tacheService.deleteByGroupeTacheCode(code);
        return res1 + groupeTacheDao.deleteByCode(code);
    }

    @Transactional
    public int deleteMultiple(List<GroupeTache> groupeTaches) {
        int res = 0;
        for (int i = 0; i < groupeTaches.size(); i++) {
            res += deleteByCode(groupeTaches.get(i).getCode());
        }
        return res;
    }

    @Transactional
    public int deleteByLotCode(String code) {
        return groupeTacheDao.deleteByLotCode(code);
    }

    public Optional<GroupeTache> findById(Long id) {
        return groupeTacheDao.findById(id);
    }

    public int updateGroupeTache(GroupeTache groupeTache){
        GroupeTache grp = findByCode(groupeTache.getCode());
        grp.setCode(groupeTache.getCode());
        grp.setLibelle(groupeTache.getLibelle());
        grp.setDescription(groupeTache.getDescription());
        grp.setAvancement(groupeTache.getAvancement());
        grp.setDateDemarrageEffective(groupeTache.getDateDemarrageEffective());
        grp.setDateFinEffective(groupeTache.getDateFinEffective());
        grp.setDateDemarragePrevu(groupeTache.getDateDemarragePrevu());
        grp.setDateFinPrevu(groupeTache.getDateFinPrevu());
        grp.setNombreJoureHommeEffectif(groupeTache.getNombreJoureHommeEffectif());
        grp.setNombreJoureHommePrevu(groupeTache.getNombreJoureHommePrevu());
        grp.setNombreJoureHommeRetard(groupeTache.getNombreJoureHommeRetard());
        grp.setPoids(groupeTache.getPoids());
        grp.setEquipe(equipeService.findByCode(groupeTache.getEquipe().getCode()));
        grp.setLot(lotService.findByCode(groupeTache.getLot().getCode()));
        grp.setCategorieGroupeTache(categorieGroupeTacheService.findByCode(groupeTache.getCategorieGroupeTache().getCode()));
        grp.setEtatGroupeTache(etatGroupeTacheService.findByCode(groupeTache.getEtatGroupeTache().getCode()));

        groupeTacheDao.save(grp);
        return 1;
    }


    public List<GroupeTache> search(GroupeTacheVO groupeTacheVO) {
        String query = "SELECT g FROM GroupeTache g where 1=1";

        if (groupeTacheVO.getClientId() != null) {
            query += " AND g.lot.projet.client.id = " + groupeTacheVO.getClientId();
        }

        if (groupeTacheVO.getProjetId() != null) {
            query += " AND g.lot.projet.id = " + groupeTacheVO.getProjetId();
        }

        if (groupeTacheVO.getLotId() != null) {
            query += " AND g.lot.id = " + groupeTacheVO.getLotId();
        }
        return entityManager.createQuery(query).getResultList();
    }

}
