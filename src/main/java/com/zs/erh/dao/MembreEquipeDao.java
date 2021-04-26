package com.zs.erh.dao;

import com.zs.erh.bean.MembreEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreEquipeDao extends JpaRepository<MembreEquipe,Long> {

    List<MembreEquipe> findByCollaborateurCode(String code);
    List<MembreEquipe> findByEquipeCode(String code);
    int deleteByEquipeCode(String code);
    public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe,String codeCollaborateur);
}
