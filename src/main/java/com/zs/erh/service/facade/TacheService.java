package com.zs.erh.service.facade;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.Tache;

import java.util.List;


public interface TacheService {
	public Tache findByCode(String code);
	public List<Tache> findByGroupeTacheCode(String code);
	public List<Tache> findAll();
	public int save(Tache tache);
	public int deleteByGroupeTacheCode(String code);
	public int deleteByCode(String code);
}
