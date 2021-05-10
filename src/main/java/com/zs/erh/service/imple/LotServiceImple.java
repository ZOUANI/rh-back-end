package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.GroupeTacheDao;
import com.zs.erh.dao.LottDao;
import com.zs.erh.dao.SroDao;
import com.zs.erh.service.facade.LotService;
import com.zs.erh.service.facade.SroService;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LotServiceImple implements LotService {
    @Autowired
    public LottDao lottDao;
    @Autowired
    public ProjetServiceImple projetServiceImple;
    @Autowired
    public GroupeTacheServiceImple groupeTacheServiceImple;
    @Autowired
    public SroService sroService;
    @Autowired
    public TacheService tacheService;
    @Autowired
    public GroupeTacheDao groupeTacheDao;

    public int save(Lot lot) {
        if (lottDao.findByCode(lot.getCode()) != null)
            return -1;
        Projet projet = projetServiceImple.findByCode(lot.getProjet().getCode());
        lot.setProjet(projet);
        lottDao.save(lot);
        return 1;
    }

    public Lot findIdLot(Long id) {
        return lottDao.findIdLot(id);
    }

    public int updateLot(Lot lot) {
        Lot lot1 = findIdLot(lot.getId());
        lot1.setSro(lot.getSro());
        lot1.setCode(lot.getCode());
        lot1.setDescription(lot.getDescription());
        lot1.setLibelle(lot.getLibelle());
        lot1.setAvancement(lot.getAvancement());
        lot1.setDateDemarrageEffective(lot.getDateDemarrageEffective());
        lot1.setDateDemarragePrevu(lot.getDateDemarragePrevu());
        lot1.setDateFinEffective(lot.getDateFinEffective());
        lot1.setDateFinPrevu(lot.getDateFinPrevu());
        lot1.setNombreJoureHommeEffectif(lot.getNombreJoureHommeEffectif());
        lot1.setNombreJoureHommePrevu(lot.getNombreJoureHommePrevu());
        lot1.setNombreJoureHommeRetard(lot.getNombreJoureHommeRetard());
        lot1.setProjet(lot.getProjet());
        lot1.setEtatLot(lot.getEtatLot());
        lot1.setResponsable(lot.getResponsable());
        lottDao.save(lot1);
        return 1;


    }

    public List<Lot> findByProjetCode(String code) {
        return lottDao.findByProjetCode(code);
    }

    public List<Lot> findByProjetId(Long id) {
        return lottDao.findByProjetId(id);
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
      List <GroupeTache> groupeTaches =  groupeTacheDao.findByLotCode(code);
        for (GroupeTache groupeTache:groupeTaches) {
            int delTache =tacheService.deleteByGroupeTacheCode(groupeTache.getCode());
        }
        int delGroup = groupeTacheServiceImple.deleteByLotCode(code);
        int delLot = lottDao.deleteByCode(code);
        return delGroup + delLot;
    }

    public int deleteByProjetCode(String code) {
        return lottDao.deleteByProjetCode(code);
    }
}
