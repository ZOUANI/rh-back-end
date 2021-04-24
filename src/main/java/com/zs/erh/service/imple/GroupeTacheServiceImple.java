package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.GroupeTache;
import com.zs.erh.dao.GroupeTacheDao;
import com.zs.erh.service.facade.CategorieGroupeTacheService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.facade.LotService;
import com.zs.erh.service.facade.GroupeTacheService;
import com.zs.erh.service.facade.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service

public class GroupeTacheServiceImple implements GroupeTacheService {

	@Autowired
	private GroupeTacheDao groupeTacheDao;

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private LotService lotService;

	@Autowired
	private CategorieGroupeTacheService categorieGroupeTacheService;

	@Autowired
	private TacheService tacheService;
	
	public List<GroupeTache> findByEquipeCode(String code) {
		return groupeTacheDao.findByEquipeCode(code);
	}

	public List<GroupeTache> findAll() {
		return groupeTacheDao.findAll();
	}

	public List<GroupeTache> findByLotCode(String code) {
		return groupeTacheDao.findByLotCode(code);
	}

	public GroupeTache findByCode(String code) {
		return groupeTacheDao.findByCode(code);
	}


	@Transactional
	public int deleteByCode(String code) {
		int res1 = this.tacheService.deleteByGroupeTacheCode(code);
		return res1+groupeTacheDao.deleteByCode(code);
	}

	public int save(GroupeTache groupeTache) {
		// Si le groupe de tache existe déja 
		if (groupeTacheDao.findByCode(groupeTache.getCode()) != null)
		{
			return -1;
		}
		else {
			groupeTache.setCode(groupeTache.getLibelle());
			groupeTache.setCategorieGroupeTache(categorieGroupeTacheService.findByCode(groupeTache.getCategorieGroupeTache().getCode()));
			groupeTache.setEquipe(equipeService.findByCode(groupeTache.getEquipe().getCode()));
			groupeTache.setLot(lotService.findByCode(groupeTache.getLot().getCode()));
			groupeTacheDao.save(groupeTache);
			return 1;
		}
	}

	@Transactional
	public int deleteByLotCode(String code){
		return groupeTacheDao.deleteByLotCode(code);
	}
}
