package com.zs.erh.service.imple;

import com.zs.erh.bean.*;
import com.zs.erh.dao.GroupeTacheDao;
import com.zs.erh.dao.LottDao;
import com.zs.erh.service.facade.LotService;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotServiceImple implements LotService {
    @Autowired
    public LottDao lottDao;
    @Autowired
    public ProjetServiceImple projetServiceImple;
    @Autowired
    public GroupeTacheServiceImple groupeTacheServiceImple;

    @Autowired
    public TacheService tacheService;
    @Autowired
    public GroupeTacheDao groupeTacheDao;

    public Lot save(Lot lot) {
        if (lottDao.findByCode(lot.getCode()) != null)
            return null;
        Projet projet = projetServiceImple.findByCode(lot.getProjet().getCode());
        lot.setProjet(projet);
        lottDao.save(lot);
        return lot;
    }


    public int updateLot(Lot lot) {
        Lot lot1 = lottDao.findById(lot.getId()).get();
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

    public List<Lot> findByProjetIdAndResponsableCode(Long id, String code) {
        return lottDao.findByProjetIdAndResponsableCode(id, code);
    }

    public Lot findByCode(String code) {
        return lottDao.findByCode(code);
    }

    public List<Lot> findByProjetAgenceChefAgenceCode(String code) {
        return lottDao.findByProjetAgenceChefAgenceCode(code);
    }

    public List<Lot> findByResponsableCode(String code) {
        return lottDao.findByResponsableCode(code);
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
    @Transactional
    public int deleteMultiple(List<Lot> lots) {
        int res=0;
        for (int i = 0; i < lots.size(); i++) {
            res+=deleteByCode(lots.get(i).getCode());
        }
        return res;
    }

    public int deleteByProjetCode(String code) {
        return lottDao.deleteByProjetCode(code);
    }
}
