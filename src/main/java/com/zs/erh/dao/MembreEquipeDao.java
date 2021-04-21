package com.zs.erh.dao;

import com.zs.erh.bean.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreEquipeDao extends JpaRepository<MembreEquipe,Long> {

    MembreEquipe findByCollaborateurCode(String code);
    MembreEquipe findByEquipeCode(String code);
}
