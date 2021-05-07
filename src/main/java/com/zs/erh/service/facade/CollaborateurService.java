package com.zs.erh.service.facade;

import com.zs.erh.bean.Collaborateur;

import java.util.List;
import java.util.Optional;


public interface CollaborateurService {
	public List<Collaborateur> findAll();

	public Collaborateur findByCode(String code);

	//public List<Collaborateur> findByEquipeDefaultCode(String code);
	Optional<Collaborateur> findById(Long id);

}
