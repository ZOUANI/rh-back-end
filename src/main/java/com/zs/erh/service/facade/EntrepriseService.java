package com.zs.erh.service.facade;

import com.zs.erh.bean.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Entreprise findByCode(String code);
    List<Entreprise> findByCodeLikeAndLibelleLike(String code, String libelle);
    int deleteByCode(String code);
    int updateEntreprise(Entreprise entreprise,Long id);
    Optional<Entreprise> findById(Long id);
    List<Entreprise> findAll();
    int save(Entreprise entreprise);
}
