package com.zs.erh.dao;

import java.util.List;

import com.zs.erh.bean.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TacheDao extends JpaRepository<Tache, Long> {
	public List<Tache> findByGroupeTacheIdAndMembreEquipeCollaborateurId(Long grpId, Long collabId);
	public List<Tache> findByMembreEquipeCollaborateurId (Long id);
	public Tache findByCode (String code);
	public List<Tache> findByGroupeTacheCode(String code);
	public int deleteByGroupeTacheCode(String code);
	public int deleteBycode(String code);
 	
}
