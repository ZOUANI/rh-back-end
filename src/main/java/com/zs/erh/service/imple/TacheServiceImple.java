package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.Tache;
import com.zs.erh.dao.TacheDao;
import com.zs.erh.service.facade.*;
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
	@Autowired
	private CategorieTacheService categorieTacheService;
	@Autowired
	private EtatTacheService etatTacheService;
	@Autowired
	private MembreEquipeService membreEquipeService;
	@Autowired
	private PeriodeService periodeService;

	
	public Tache findByCode(String code) {
		return tacheDao.findByCode(code);
	}

	public List<Tache> findByGroupeTacheCode(String code) {
		return tacheDao.findByGroupeTacheCode(code);
	}

	public List<Tache> findAll() {
		return tacheDao.findAll();
	}

	public int save(Tache tache) {
		// Si la tache existe déja
		if (tacheDao.findByCode(tache.getCode()) != null)
		{
			return -1;
		}
		else {
			tache.setCode(tache.getLibelle());
			tache.setGroupeTache(groupeTacheService.findByCode(tache.getGroupeTache().getCode()));
			tache.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
			tache.setEtatTache(etatTacheService.findByCode(tache.getEtatTache().getCode()));
			tache.setPeriode(periodeService.findByCode(tache.getPeriode().getCode()));
			tache.setMembreEquipe(membreEquipeService.findByEquipeCodeAndCollaborateurCode(tache.getMembreEquipe().getEquipe().getCode(),
					tache.getMembreEquipe().getCollaborateur().getCode()));
			tacheDao.save(tache);
			return 1;
		}
	}

	@Transactional
	public int deleteByGroupeTacheCode(String code) {
		return tacheDao.deleteByGroupeTacheCode(code);
	}

	@Transactional
	public int deleteByCode(String code) {
		return tacheDao.deleteBycode(code);
	}
}
