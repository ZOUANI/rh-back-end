package com.zs.erh.service.facade;

import com.zs.erh.bean.Entreprise;
import com.zs.erh.service.vo.EntrepriseVO;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Entreprise findByCode(String code);
    List<Entreprise> findByCodeLikeAndLibelleLike(String code, String libelle);
    int deleteByCode (String code);
    public int deleteByCode(List<Entreprise> entreprises);
    Entreprise update (Entreprise entreprise);
    Optional<Entreprise> findById(Long id);
    List<Entreprise> findAll();
    Entreprise save(Entreprise entreprise);
    List<Entreprise> findByCriteria(EntrepriseVO entrepriseVO);
}

