package com.zs.erh.dao;


import com.zs.erh.bean.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollaborateurDao extends JpaRepository<Collaborateur, Long>{
	public List<Collaborateur> findAll();
	public Collaborateur findByCode(String code);
}
