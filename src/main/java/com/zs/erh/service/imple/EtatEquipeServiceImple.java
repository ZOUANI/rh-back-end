package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.dao.EtatEquipeDao;
import com.zs.erh.service.facade.EtatEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EtatEquipeServiceImple implements EtatEquipeService {
	@Autowired
	private EtatEquipeDao etatEquipeDao;

	public List<EtatEquipe> findAll() {
		return etatEquipeDao.findAll();
	}

	@Override
	public EtatEquipe findByCode(String code) {
		return etatEquipeDao.findByCode(code);
	}
	
}
