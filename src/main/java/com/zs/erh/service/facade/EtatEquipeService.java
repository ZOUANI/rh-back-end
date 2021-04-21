package com.zs.erh.service.facade;

import com.zs.erh.bean.EtatEquipe;

import java.util.List;


public interface EtatEquipeService {
	
	public List<EtatEquipe> findAll();
	
	public EtatEquipe findByCode(String code);
}
