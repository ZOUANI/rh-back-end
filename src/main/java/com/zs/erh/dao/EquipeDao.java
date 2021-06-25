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
    @Query(value = "SELECT e FROM Equipe e where e.etatEquipe.id = 401 AND e.responsable.id = :id")
    List<Equipe> findByResponsable(@Param("id") Long id);

    @Query(value = "select distinct e.equipe from MembreEquipe e where e.collaborateur.code = :code")
   List<Equipe> findByCollab(@Param("code") String code);

    List<Equipe> findByResponsableCode(String code);

    List<Equipe> findByEtatEquipeCode(String code);
    List<Equipe> findByAgenceChefAgenceCode(String code);

}
