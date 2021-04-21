package com.zs.erh.dao;

import java.util.List;

import com.zs.erh.bean.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long>{
	public List<Equipe> findAll();
	public List<Equipe> findByEtatEquipeCode(String code);
	public Equipe findByCode(String code);
	public int deleteByCode(String code);
}
