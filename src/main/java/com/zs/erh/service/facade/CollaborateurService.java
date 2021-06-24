package com.zs.erh.service.facade;

import com.zs.erh.bean.Collaborateur;

import java.util.List;
import java.util.Optional;


public interface CollaborateurService {
	public List<Collaborateur> findAll();

	public Collaborateur findByCode(String code);

	Optional<Collaborateur> findById(Long id);

	public Collaborateur findByLogin(String login);
	List<Collaborateur> findByAgenceChefAgenceCode(String code);

	public int save(Collaborateur collaborateur);

	public List<Collaborateur> findByAgenceCode(String code);

	public List<Collaborateur> findCollaborateurs(String login);

}
