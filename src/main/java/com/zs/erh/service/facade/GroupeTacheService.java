package com.zs.erh.service.facade;


import com.zs.erh.bean.GroupeTache;

import java.util.List;




public interface GroupeTacheService {
	public List<GroupeTache> findByEquipeCode(String code);

	public List<GroupeTache> findAll();

	public List<GroupeTache> findByLotCode(String code);

	public GroupeTache findByCode(String code);

	public int deleteByLotCode(String code);
	
	public int deleteByCode(String code);

	public int save(GroupeTache groupeTache);
}
