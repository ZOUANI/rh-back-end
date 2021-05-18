package com.zs.erh.service.facade;

import com.zs.erh.bean.MembreEquipe;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



public interface MembreEquipeService {
	public List<MembreEquipe> findAll();
	public List<MembreEquipe> findByEquipeCode(String code);
	public List<MembreEquipe> findByEquipeId(Long id);
	public int deleteByEquipeCode(String code);
	List<MembreEquipe> findByCollaborateurCode(String code);
	public int update(Long id,MembreEquipe membreEquipe);
	public int save(MembreEquipe membreEquipe);
	public MembreEquipe findByEquipeCodeAndCollaborateurCode(String codeEquipe, String codeCollaborateur);
	public int deleteByEquipeCodeAndCollaborateurCode(String codeEquipe,String codeCollaborateur);
}
