package com.zs.erh.service.imple;

import java.util.List;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CollaborateurServiceImple implements CollaborateurService {
	@Autowired
	private CollaborateurDao collaborateurDao;

	public List<Collaborateur> findAll() {
		return collaborateurDao.findAll();
	}

	public Collaborateur findByCode(String code) {
		return collaborateurDao.findByCode(code);
	}
	
}
