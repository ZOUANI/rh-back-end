package com.zs.erh.service.imple;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Projet;
import com.zs.erh.dao.ProjetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjetServiceImple {

    public int save(Projet projet) {
        if (findByCode(projet.getCode()) != null) {
            return -1;
        } else {
            projetDao.save(projet);
            return 1;
        }
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

    @Autowired
    public ProjetDao projetDao;
    @Autowired
    public LotServiceImple lotServiceImple;
}
