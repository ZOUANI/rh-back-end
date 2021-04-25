package com.zs.erh.service.imple;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.dao.EntrepriseDao;
import com.zs.erh.service.facade.ClientService;
import com.zs.erh.service.facade.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    //flyWayDb
    public List<Entreprise> findAll() {
        return entrepriseDao.findAll();
    }

    public int save(Entreprise entreprise) {
        if(findByCode(entreprise.getCode())!=null){
            return -1;
        }else{
            entrepriseDao.save(entreprise);
            clientService.save(entreprise,entreprise.getClients());
            return 1;
        }

    }
    public int updateEntreprise(Entreprise entreprise,Long id){
        Optional<Entreprise> foundedEntreprise = entrepriseDao.findById(id);
        if(foundedEntreprise.isPresent()){
            if(foundedEntreprise.get().getLibelle()==entreprise.getLibelle()){
                foundedEntreprise.get().setCode(entreprise.getCode());
                foundedEntreprise.get().setDescription(entreprise.getDescription());
                entrepriseDao.save(foundedEntreprise.get());
                return 1;
            }else {
                return -1;
            }
        }else{
            save(entreprise);
            return 2;
        }
    }


    public Optional<Entreprise> findById(Long id) {
        return entrepriseDao.findById(id);
    }

    @Autowired
    private EntrepriseDao entrepriseDao;
    @Autowired
    private ClientService clientService;
}