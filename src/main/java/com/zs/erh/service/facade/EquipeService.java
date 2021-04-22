package com.zs.erh.service.facade;

import com.zs.erh.bean.Equipe;

import java.util.List;


public interface EquipeService {
	public List<Equipe> findAll();
	public List<Equipe> findByEtatEquipeCode(String code);
	public Equipe findByCode(String code);
}
