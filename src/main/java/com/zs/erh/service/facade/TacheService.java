package com.zs.erh.service.facade;

import com.zs.erh.bean.Tache;
import com.zs.erh.service.vo.CollaborateurVo;
import com.zs.erh.service.vo.TacheVo;

import java.util.Date;
import java.util.List;


public interface TacheService {
	public Tache findByCode(String code);
	public List<Tache> findByGroupeTacheCode(String code);
	public List<Tache> findAll();
	public int save(Tache tache);
	public int deleteByGroupeTacheCode(String code);
	public int deleteByCode(String code);
	public int updateTache(Tache tache);

	/*Aymane Start here statistiques*/
	public List<TacheVo> calcStatistique(TacheVo tacheVo);

	public List<CollaborateurVo> calcStatistiqueSuiviCollaborateur(Date dateMin, Date dateMax);
}
