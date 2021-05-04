package com.zs.erh.service.facade;

import com.zs.erh.bean.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetService {

    public List<Projet> findByClientCode(String code);

    List<Projet> findAll();

    List<Projet> findByNroCode(String code);

    Projet findByCode(String Code);

    int deleteByCode(String code);

    int save(Projet projet);

    int deleteByNroCode(String code);
    void update(Projet projet);
    Projet findId( Long id);

}
