package com.zs.erh.service.imple;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.service.facade.CategorieCollaborateurService;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.util.HashageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CollaborateurServiceImple implements CollaborateurService {
	@Autowired
	private CollaborateurDao collaborateurDao;

	@Autowired
	private CategorieCollaborateurService categorieCollaborateurService;

	public Collaborateur findByLogin(String login) {
		return collaborateurDao.findByLogin(login);
	}

	public int save(Collaborateur collaborateur) {
		if (collaborateurDao.findByCode(collaborateur.getCode()) != null) {
            return -1;
        }
        else {
            collaborateurDao.save(collaborateur);
            return 1;
        }
	}

//	public int save(Collaborateur collaborateur) {
//		Collaborateur c = findByLogin(collaborateur.getLogin());
//		if (c == null) {
//			collaborateur.setCategorieCollaborateur(categorieCollaborateurService.findByCode("agent"));
//			String hash = HashageUtil.sha256(collaborateur.getPassword());
//			collaborateur.setPassword(hash);
////			collaborateur.setId(generateId("id"));
//			collaborateur.setMustChangePassword(false);
//			collaborateurDao.save(collaborateur);
//			return 1;
//		}
//		return -1;
//	}

	public List<Collaborateur> findAll() {
		return collaborateurDao.findAll();
	}

	public Collaborateur findByCode(String code) {
		return collaborateurDao.findByCode(code);
	}

//	public List<Collaborateur> findByEquipeDefaultCode(String code) {
//		return collaborateurDao.findByEquipeDefaultCode(code);
//	}
public Optional<Collaborateur> findById(Long id) {
	return collaborateurDao.findById(id);
}
	
}
