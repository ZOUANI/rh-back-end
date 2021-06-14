package com.zs.erh.dao;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT distinct p.projet from ProjetEquipe p where p.equipe.responsable.id = :chefEquipeId")
    public List<Projet> findProjetsByChefEquipeId(@Param("chefEquipeId") Long chefEquipeId);

    @Query("SELECT distinct p.projet from ProjetEquipe p where p.projet.client.id = :clientId and p.equipe.responsable.id = :chefEquipeId")
    public List<Projet> findProjetsByClientIdAndChefEquipeId(@Param("clientId") Long clientId, @Param("chefEquipeId") Long chefEquipeId);

}
