package com.zs.erh.service.facade;

import com.zs.erh.bean.Projet;
import com.zs.erh.bean.ProjetEquipe;

import java.util.List;

public interface ProjetEquipeService {

    int save(Projet projet, List<ProjetEquipe> projetEquipes);
    List<ProjetEquipe> findByProjetCode(String code);
    int deleteByProjetCode(String code);
    List<ProjetEquipe> findAll();
}
