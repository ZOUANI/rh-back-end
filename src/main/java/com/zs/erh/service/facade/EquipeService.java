package com.zs.erh.service.facade;

import com.zs.erh.bean.Equipe;
import com.zs.erh.service.vo.EquipeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface EquipeService {
	public List<Equipe> findAll();
	public List<Equipe> findByEtatEquipeCode(String code);
	public Equipe findByCode(String code);
	Equipe findByResponsableCode(String code);
	public int deleteByCode(String code);
	public int save(Equipe equipe);
	public int update(Long id, Equipe equipe);
	public void deleteById(long id);
	public List<Equipe> search(EquipeVO equipeVO);
	}
