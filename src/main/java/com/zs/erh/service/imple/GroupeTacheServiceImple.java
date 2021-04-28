package com.zs.erh.service.imple;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.dao.GroupeTacheDao;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.LotService;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.facade.TacheService;
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
    private EntityManager entityManager;



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

    public int save(GroupeTache groupeTache) {
        // Si le groupe de tache existe déja
        if (groupeTacheDao.findByCode(groupeTache.getCode()) != null) {
            return -1;
        } else {
            groupeTache.setCode(groupeTache.getLibelle());
            groupeTache.setCategorieGroupeTache(categorieGroupeTacheService.findByCode(groupeTache.getCategorieGroupeTache().getCode()));
            groupeTache.setEquipe(equipeService.findByCode(groupeTache.getEquipe().getCode()));
            groupeTache.setLot(lotService.findByCode(groupeTache.getLot().getCode()));
            groupeTacheDao.save(groupeTache);
            return 1;
        }
    }


    @Transactional
    public int deleteByCode(String code) {
        int res1 = this.tacheService.deleteByGroupeTacheCode(code);
        return res1 + groupeTacheDao.deleteByCode(code);
    }

    @Transactional
    public int deleteByLotCode(String code) {
        return groupeTacheDao.deleteByLotCode(code);
    }

    public Optional<GroupeTache> findById(Long id) {
        return groupeTacheDao.findById(id);
    }

    public int updateGroupeTache(GroupeTache groupeTache, Long id) {
        Optional<GroupeTache> foundedGroupeTache = groupeTacheDao.findById(id);
        if (foundedGroupeTache.isPresent()) {
            if (foundedGroupeTache.get().getLibelle() == groupeTache.getLibelle()) {
                foundedGroupeTache.get().setCode(groupeTache.getCode());
                foundedGroupeTache.get().setDescription(groupeTache.getDescription());
                groupeTacheDao.save(foundedGroupeTache.get());
                return 1;
            } else {
                return -1;
            }
        } else {
            save(groupeTache);
            return 2;
        }
    }


    public List<GroupeTache> search(GroupeTacheVO groupeTacheVO){
        String query = "SELECT g FROM GroupeTache g where 1=1";
        if(groupeTacheVO.getCode()!=null){
            query+=" AND g.code LIKE '%" + groupeTacheVO.getCode() + "%'";
        }if(groupeTacheVO.getLibelle() != null){
            query+= " AND g.libelle LIKE '%" + groupeTacheVO.getLibelle() + "%'";
        }if(groupeTacheVO.getDescription()!=null){
            query+=" AND g.description LIKE '%" + groupeTacheVO.getDescription() + "%'";
        }
        return  entityManager.createQuery(query).getResultList();
    }


}
