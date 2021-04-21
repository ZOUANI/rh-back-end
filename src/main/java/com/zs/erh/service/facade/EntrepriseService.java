package com.zs.erh.service.facade;

import com.zs.erh.bean.Entreprise;

import java.util.List;

public interface EntrepriseService {
    Entreprise findByLibelle(String libelle);
    List<Entreprise> findByLibelleLikeAndCodeLike(String libelle, String code);
    int deleteByLibelle(String libelle);
    List<Entreprise> findAll();
    int save(Entreprise entreprise);
}
