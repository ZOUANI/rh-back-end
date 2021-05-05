package com.zs.erh.service.imple;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.EntrepriseDao;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.facade.EntrepriseService;
import com.zs.erh.service.util.StringUtil;
import com.zs.erh.service.vo.EntrepriseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImple implements EntrepriseService {

    public Entreprise findByCode(String code) {
        return entrepriseDao.findByCode(code);
    }

    public List<Entreprise> findByCodeLikeAndLibelleLike(String code, String libelle) {
        return entrepriseDao.findByCodeLikeAndLibelleLike(code, libelle);
    }
    @Transactional
    public int deleteByCode(String code) {
        int deleteByEntrepriseCode = clientService.deleteByEntrepriseCode(code);
        int deleteByCode = entrepriseDao.deleteByCode(code);
        return  deleteByEntrepriseCode + deleteByCode;
    }

    public List<Entreprise> findAll() {
        return entrepriseDao.findAll();
    }

    public int save(Entreprise entreprise) {
        if(findByCode(entreprise.getCode())!=null){
            return -1;
        }else{
            entrepriseDao.save(entreprise);
            return 1;
        }
    }

    public List<Entreprise> findByCriteria(EntrepriseVO entrepriseVO){
        String query="SELECT e FROM Entreprise e WHERE 1=1";
        if(StringUtil.isNotEmpty(entrepriseVO.getCode())){
            query+=" AND e.code LIKE '%"+entrepriseVO.getCode()+"%'";
        }
        if(StringUtil.isNotEmpty(entrepriseVO.getLibelle())){
            query+=" AND e.libelle LIKE '%"+entrepriseVO.getLibelle()+"%'";
        }
        return entityManager.createQuery(query).getResultList();
    }

    public int updateEntreprise(Entreprise entreprise){
        Entreprise entreprise1 = findByCode(entreprise.getCode());
        entreprise1.setLibelle(entreprise.getLibelle());
        entreprise1.setDescription(entreprise.getDescription());
        entrepriseDao.save(entreprise1);
        return 1;
    }


    public Optional<Entreprise> findById(Long id) {
        return entrepriseDao.findById(id);
    }

    @Autowired
    private EntrepriseDao entrepriseDao;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EntityManager entityManager;

}