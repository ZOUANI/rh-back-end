package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.Tache;
import com.zs.erh.dao.TacheDao;
import com.zs.erh.service.facade.*;
import com.zs.erh.service.vo.TacheVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class TacheServiceImple extends AbstractFacade<Tache> implements TacheService {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private TacheDao tacheDao;
	
	@Autowired
	private GroupeTacheService groupeTacheService;

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
		if(tache.getCode().isEmpty()){
			tache.setCode(tache.getLibelle());
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
		else {
			if (tacheDao.findByCode(tache.getCode()) != null) {
				return -1;
			} else {
				tacheDao.save(tache);
				return 1;
			}
		}

	}

	public int updateTache(Tache tache){
		Tache tacheUpdated = findByCode(tache.getCode());
		tacheUpdated.setCode(tache.getCode());
		tacheUpdated.setLibelle(tache.getLibelle());
		tacheUpdated.setDescription(tache.getDescription());
		tacheUpdated.setDateDemarrageEffective(tache.getDateDemarrageEffective());
		tacheUpdated.setDateFinEffective(tache.getDateFinEffective());
		tacheUpdated.setPeriode(periodeService.findByCode(tache.getPeriode().getCode()));
		tacheUpdated.setCategorieTache(categorieTacheService.findByCode(tache.getCategorieTache().getCode()));
		tacheUpdated.setEtatTache(etatTacheService.findByCode(tache.getEtatTache().getCode()));

		tacheDao.save(tacheUpdated);
		return 1;
	}

	@Transactional
	public int deleteByGroupeTacheCode(String code) {
		return tacheDao.deleteByGroupeTacheCode(code);
	}

	@Transactional
	public int deleteByCode(String code) {
		return tacheDao.deleteBycode(code);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/* ! Aymane Start something here */
	public List<TacheVo> calcStatistique(TacheVo tacheVo) {
		System.out.println("tacheVo = " + tacheVo);
		String query = "SELECT new com.zs.erh.service.vo.TacheVo(t.groupeTache.lot,COUNT(t.periode.id)) FROM Tache t WHERE 1=1";
		query += addCriteria(tacheVo);
		query += " GROUP BY t.groupeTache.lot.id";
		System.out.println("query = " + query);
		List<TacheVo> res = getEntityManager().createQuery(query).getResultList();
		System.out.println("res = " + res);
		return res;
	}

	public String addCriteria(TacheVo tacheVo) {
		String query = "";
		query += addConstraint("t.annee", tacheVo.getAnnee());
		query += addConstraint("t.mois", tacheVo.getMois());
		query += addConstraint("t.semaine", tacheVo.getSemaine());
		query += addConstraintMinMaxDate("t", "dateDemarrageEffective", tacheVo.getDateDemarrageEffectiveMin(), tacheVo.getDateDemarrageEffectiveMax());
		query += addConstraint("t.membreEquipe.collaborateur.id", tacheVo.getResponsableId());
		query += addConstraint("t.membreEquipe.id", tacheVo.getMembreEquipeId());
		query += addConstraint("t.membreEquipe.equipe.id", tacheVo.getEquipeId());
		query += addConstraint("t.groupeTache.lot.projet.id", tacheVo.getProjetId());
		query += addConstraint("t.groupeTache.lot.id", tacheVo.getLotId());
		query += addConstraint("t.groupeTache.lot.projet.client.id", tacheVo.getClientId());
		query += addConstraint("t.periode.id", tacheVo.getPeriodeId());
		query += addConstraint("t.groupeTache.lot.sro.id", tacheVo.getSroId());
		query += addConstraint("t.groupeTache.lot.projet.nro.id", tacheVo.getNroId());
		return query;
	}
	/* ! End it here dont touche it*/



	@Override
	public Class<Tache> getEntityClass() {
		return Tache.class;
	}
}
