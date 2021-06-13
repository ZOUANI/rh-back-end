package com.zs.erh.dao;

import com.zs.erh.bean.ProjetEquipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetEquipeDao extends JpaRepository<ProjetEquipe,Long> {
    public List<ProjetEquipe> findAll();
    public List<ProjetEquipe> findByProjetId(Long id);
    public List<ProjetEquipe> findByProjetIdAndEquipeAgenceChefAgenceId(Long projetId, Long chefId);
    public List<ProjetEquipe> findByProjetClientIdAndEquipeResponsableCode(Long id, String code);
    public List<ProjetEquipe> findByEquipeResponsableCode(String code);
    List<ProjetEquipe> findByProjetCode(String code);
    int deleteByProjetCode(String code);
    void deleteById(Long id);

}
