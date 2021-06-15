package com.zs.erh.service.facade;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;

import java.util.List;

public interface ProjetEquipeService {
    public List<ProjetEquipe> findByProjetId(Long id);
    public List<ProjetEquipe> findByProjetIdAndEquipeAgenceChefAgenceId(Long projetId, Long chefId);
    public List<ProjetEquipe> findByProjetClientIdAndEquipeResponsableCode(Long id, String code);
    public List<ProjetEquipe> findByEquipeResponsableCode(String code);
    int save(Projet projet, List<ProjetEquipe> projetEquipes);
    ProjetEquipe saveDirect(ProjetEquipe projetEquipe);
    List<ProjetEquipe> findByProjetCode(String code);
    int deleteByProjetCode(String code);
    List<ProjetEquipe> findAll();
    void deleteById(Long id);
    public List<Projet> findProjetsByChefEquipeId(Long chefEquipeId);
    public List<Projet> findProjetsByClientIdAndChefEquipeId(Long clientId, Long chefEquipeId);
}
