package com.zs.erh.dao;

import java.util.List;

import com.zs.erh.bean.EtatEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EtatEquipeDao extends JpaRepository<EtatEquipe, Long>{
	public List<EtatEquipe> findAll();
	
	public EtatEquipe findByCode(String code);
}
