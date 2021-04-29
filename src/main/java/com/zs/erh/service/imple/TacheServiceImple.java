package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.bean.Tache;
import com.zs.erh.dao.TacheDao;
import com.zs.erh.service.facade.CategorieTacheService;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TacheServiceImple implements TacheService {
	@Autowired
	private TacheDao tacheDao;
	
	@Autowired
	private GroupeTacheService groupeTacheService;

	@Autowired
	private CategorieTacheService categorieTacheService;

	@Autowired
	private CollaborateurService collaborateurService;
	
	public Tache findByCode(String code) {
		return tacheDao.findByCode(code);
	}

	public List<Tache> findByGroupeTacheCode(String code) {
		return tacheDao.findByGroupeTacheCode(code);
	}

	public List<Tache> findAll() {
		return tacheDao.findAll();
	}

	@Transactional
	public int deleteByGroupeTacheCode(String code) {
		return tacheDao.deleteByGroupeTacheCode(code);
	}

	@Transactional
	public int deleteByCode(String code) {
		return tacheDao.deleteBycode(code);
	}


	public int save(Tache tache) {
		// Si le groupe de tache existe déja
		if (tacheDao.findByCode(tache.getCode()) != null)
		{
			return -1;
		}
		else {
			tache.setCode(tache.getLibelle());
			tache.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
			tache.setGroupeTache(groupeTacheService.findByCode(tache.getGroupeTache().getCode()));
			tacheDao.save(tache);
			return 1;
		}
	}
}
