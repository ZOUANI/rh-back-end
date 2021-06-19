package com.zs.erh.service.facade;

import com.zs.erh.bean.Tache;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.TacheVo;

import java.util.Date;
import java.util.List;


public interface TacheService {
	public List<Tache> findByGroupeTacheIdAndMembreEquipeCollaborateurId(Long grpId, Long collabId);
	public List<Tache> findByMembreEquipeCollaborateurId (Long id);
	public Tache findByCode(String code);
	public List<Tache> findByGroupeTacheCode(String code);
	public List<Tache> findAll();
	public Tache save(Tache tache);
	public int deleteByGroupeTacheCode(String code);
	public int deleteByCode(String code);
	public int deleteMultiple(List<Tache> taches);
	public int updateTache(Tache tache);
	public List<Tache> search(TacheVo tacheVo);
	public List<TacheVo> calcStatistique(TacheVo tacheVo);
	public List<CollaborateurVo> suivreCollaborateurs(CollaborateurVo collaborateurVo);
	public List<CollaborateurVo> calcStatistiqueSuiviCollaborateur(CollaborateurVo collabVo);
	public Tache saveForCollaborateur(Tache tache);
	public Tache findByPeriodeIdAndMembreEquipeIdAndDateDemarrageEffective(Tache tache);
}
