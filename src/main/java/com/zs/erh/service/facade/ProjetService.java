package com.zs.erh.service.facade;

import com.zs.erh.bean.ChefAgence;
import com.zs.erh.bean.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetService {

    public List<Projet> findByClientId(Long id);

    public List<Projet> findByAgenceChefAgenceCode(String code);;

    public List<Projet> findByResponsableCode(String code);

    List<Projet> findAll();

    Projet findByCode(String Code);

    int deleteByCode(String code);

    int deleteMultiple(List<Projet> projets);

    Projet save(Projet projet);

    void update(Projet projet);
    Projet findId( Long id);

}
