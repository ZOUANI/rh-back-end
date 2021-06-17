package com.zs.erh.dao;

import com.zs.erh.bean.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeDao extends JpaRepository<Equipe,Long> {
    Equipe findByCode(String code);
    int deleteByCode(String code);
    List<Equipe> findByResponsableCode(String code);
    List<Equipe> findByEtatEquipeCode(String code);
    List<Equipe> findByAgenceChefAgenceCode(String code);

}
