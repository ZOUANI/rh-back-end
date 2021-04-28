package com.zs.erh.service.facade;

import com.zs.erh.bean.Collaborateur;

import java.util.List;





public interface CollaborateurService {
	public List<Collaborateur> findAll();

	public Collaborateur findByCode(String code);
}
