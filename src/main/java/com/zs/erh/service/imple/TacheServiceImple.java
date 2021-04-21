package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.bean.GroupeTache;
import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.bean.Tache;
import com.zs.erh.dao.TacheDao;
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

	public int deleteByGroupeTacheCode(String Code) {
		return tacheDao.deleteByGroupeTacheCode(Code);
	}

	@Override
	public int deleteByCode(String code) {
		return tacheDao.deleteBycode(code);
	}
}
