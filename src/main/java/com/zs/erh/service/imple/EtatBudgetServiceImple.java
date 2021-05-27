package com.zs.erh.service.imple;

import com.zs.erh.bean.EtatBudget;
import com.zs.erh.dao.EtatBudgetDao;
import com.zs.erh.service.facade.EtatBudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatBudgetServiceImple implements EtatBudgetService {
    @Autowired
    private EtatBudgetDao etatBudgetDao;

    public Optional<EtatBudget> findById(Long id){
        return etatBudgetDao.findById(id);
    }
    public List<EtatBudget> findAll(){
        return etatBudgetDao.findAll();
    }
    public EtatBudget findByCode(String code){
        return etatBudgetDao.findByCode(code);
    }

    public List<EtatBudget> findByLibelle(String libelle) {
        return etatBudgetDao.findByLibelle(libelle);
    }

    public int deleteByCode(String code){
        return etatBudgetDao.deleteByCode(code);
    }


}
