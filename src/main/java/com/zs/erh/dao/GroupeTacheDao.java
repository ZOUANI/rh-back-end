package com.zs.erh.dao;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.GroupeTache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface GroupeTacheDao extends JpaRepository<GroupeTache, Long> {
	public List<GroupeTache> findByLotProjetAgenceChefAgenceCode(String code);
	public List<GroupeTache> findByEquipeResponsableCode(String code);
	public List<GroupeTache> findByLotResponsableCode(String code);
	public List<GroupeTache> findByEquipeCode(String code);
	public List<GroupeTache> findAll();
	public List<GroupeTache> findByLotCode(String code);
	public GroupeTache findByCode(String code);
	public Optional<GroupeTache> findById(Long id);
	public int deleteByCode(String code);
	public int deleteByLotCode(String code);

}
