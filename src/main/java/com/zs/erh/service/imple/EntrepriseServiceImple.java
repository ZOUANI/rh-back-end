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

    @Autowired
    private EntrepriseDao entrepriseDao;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EntityManager entityManager;

    public Optional<Entreprise> findById(Long id) {
        return entrepriseDao.findById(id);
    }

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

    public Entreprise save(Entreprise entreprise) {
        if(findByCode(entreprise.getCode())!=null){
            return null;
        }else{
            entrepriseDao.save(entreprise);
            return entreprise;
        }
    }

    public List<Entreprise> findByCriteria(EntrepriseVO entrepriseVO){
        String query="SELECT e FROM Entreprise e WHERE 1=1";
        if(StringUtil.isNotEmpty(entrepriseVO.getLibelle())){
            query+=" AND e.libelle LIKE '%"+entrepriseVO.getLibelle()+"%'";
        }
        return entityManager.createQuery(query).getResultList();
    }

    public Entreprise update(Entreprise entreprise) {
        return entrepriseDao.save(entreprise);
    }


    @Transactional
    public int deleteByCode(List<Entreprise> entreprises) {
        int res=0;
        for (int i = 0; i < entreprises.size(); i++) {
            res+=deleteByCode(entreprises.get(i).getCode());
        }
        return res;
    }
}