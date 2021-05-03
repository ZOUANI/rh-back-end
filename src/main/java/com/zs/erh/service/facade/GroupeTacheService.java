package com.zs.erh.service.facade;


import com.zs.erh.bean.GroupeTache;
import com.zs.erh.service.vo.GroupeTacheVO;

import java.util.List;
import java.util.Optional;


public interface GroupeTacheService {
	public List<GroupeTache> findByEquipeCode(String code);

	public List<GroupeTache> findAll();

	public List<GroupeTache> findByLotCode(String code);

	public GroupeTache findByCode(String code);

	public int deleteByLotCode(String code);
	
	public int deleteByCode(String code);

	public int save(GroupeTache groupeTache);

	public Optional<GroupeTache> findById(Long id);

	public int updateGroupeTache(GroupeTache groupeTache);

	public List<GroupeTache> search(GroupeTacheVO groupeTacheVO);
}
