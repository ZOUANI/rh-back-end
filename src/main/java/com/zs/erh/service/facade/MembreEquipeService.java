package com.zs.erh.service.facade;

import com.zs.erh.bean.MembreEquipe;

import java.util.List;



public interface MembreEquipeService {
	public List<MembreEquipe> findByEquipeCode(String code);
	public int deleteByEquipeCode(String code);
}
