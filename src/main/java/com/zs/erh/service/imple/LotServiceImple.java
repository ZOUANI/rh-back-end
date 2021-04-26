package com.zs.erh.service.imple;

import com.zs.erh.bean.Lot;
import com.zs.erh.bean.Projet;
import com.zs.erh.bean.Sro;
import com.zs.erh.dao.LottDao;
import com.zs.erh.service.facade.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotServiceImple implements LotService{
    @Autowired
    public LottDao lottDao;
    @Autowired
    public ProjetServiceImple projetServiceImple;
    @Autowired
    public GroupeTacheServiceImple groupeTacheServiceImple;

    public int save(Lot lot) {
        if (findByCode(lot.getCode()) != null)
            return -1;
        Projet projet = projetServiceImple.findByCode(lot.getProjet().getCode());
            lot.setProjet(projet);
            lottDao.save(lot);
        return 1;
    }

    public List<Lot> findByProjetCode(String code) {
        return lottDao.findByProjetCode(code);
    }

    public Lot findByCode(String code) {
        return lottDao.findByCode(code);
    }

    public List<Sro> findBySroCode(String code) {
        return lottDao.findBySroCode(code);
    }

    public List<Lot> findAll() {
        return lottDao.findAll();
    }
    @Transactional
    public int deleteByCode(String code) {
        int delGroup = groupeTacheServiceImple.deleteByLotCode(code);
        int delLot = lottDao.deleteByCode(code);
        return delGroup + delLot;
    }

    public int deleteByProjetCode(String code) {
        return lottDao.deleteByProjetCode(code);
    }
}
