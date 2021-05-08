package com.zs.erh.service.facade;

import com.zs.erh.bean.DemandeConge;
import com.zs.erh.service.vo.DemandeCongeVo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DemandeCongeService {
    Optional<DemandeConge> findById(Long id);
    List<DemandeConge> findByEtatDemandeCongeCode(String code);
    List<DemandeConge> findAll();
    void deleteById(Long id);
    int save(DemandeConge demandeConge);
    int update(DemandeConge demandeConge);
    public Long calcNombreJourTotal(Long collaborateurId, Date dateDebut, Date dateFin);
    public List<DemandeCongeVo> findByCollaborateurAndDateMinAndMax(Long collaborateurId, Date dateDebut, Date dateFin);
}

