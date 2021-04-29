package com.zs.erh.service.facade;

import com.zs.erh.bean.MembreEquipe;

import java.util.List;



public interface MembreEquipeService {
	public List<MembreEquipe> findByEquipeCode(String code);
	public MembreEquipe findByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur);
	List<MembreEquipe> findByCollaborateurCode(String code);
	List<MembreEquipe> findAll();
	public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur);
	public int deleteByEquipeCode(String code);
}
