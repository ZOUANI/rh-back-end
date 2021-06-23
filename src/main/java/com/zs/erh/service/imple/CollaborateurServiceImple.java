package com.zs.erh.service.imple;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.Admin;
import com.zs.erh.bean.Collaborateur;
import com.zs.erh.dao.CollaborateurDao;
import com.zs.erh.service.facade.CategorieCollaborateurService;
import com.zs.erh.service.facade.CollaborateurService;
import com.zs.erh.service.facade.EquipeService;
import com.zs.erh.service.util.HashageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class CollaborateurServiceImple implements CollaborateurService {
	@Autowired
	private CollaborateurDao collaborateurDao;

	@Autowired
	private CategorieCollaborateurService categorieCollaborateurService;
	@Autowired
	private EquipeService equipeService;

	@Autowired
	private CollaborateurService collaborateurService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Collaborateur> findByAgenceChefAgenceCode(String code) {
		return collaborateurDao.findByAgenceChefAgenceCode(code);
	}

	public Collaborateur findByLogin(String login) {
		return collaborateurDao.findByLogin(login);
	}
	public List<Collaborateur> findByAgenceCode(String code){
		return collaborateurDao.findByAgenceCode(code);
	}

	public List<Collaborateur> findCollaborateurs(String login){
		Collaborateur collaborateur = collaborateurDao.findByLogin(login);
		return collaborateurDao.findByAgenceCode(collaborateur.getAgence().getCode());
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
	public Collaborateur findByLoginAndPassword(String login, String password){
		return collaborateurDao.findByLoginAndPassword(login,password);
	}

	public Collaborateur saveCollaborateur(Collaborateur collaborateur){
		if(collaborateurDao.findByLogin(collaborateur.getLogin()) != null){
			return null;
		}else{
			collaborateur.setCode(collaborateur.getLogin());
			passwordEncoder.encode(collaborateur.getPassword());
			collaborateurDao.save(collaborateur);
			return collaborateur;
		}
	}
	public Collaborateur signIn(Collaborateur collaborateur){
		Collaborateur foundedCollaborateur = this.collaborateurDao.findByLogin(collaborateur.getLogin());
		if(foundedCollaborateur == null){
			return null;
		}
		if (!foundedCollaborateur.getPassword().equals(collaborateur.getPassword())){
			return null;
		}else{
			foundedCollaborateur.setNbrCnx(foundedCollaborateur.getNbrCnx()+1);
			foundedCollaborateur.setCode(foundedCollaborateur.getId().toString());
			collaborateurDao.save(foundedCollaborateur);
			return foundedCollaborateur;
		}
	}

	public List<Collaborateur> findAll() {
		return collaborateurDao.findAll();
	}

	public Collaborateur findByCode(String code) {
		return collaborateurDao.findByCode(code);
	}


	public Optional<Collaborateur> findById(Long id) {
		return collaborateurDao.findById(id);
	}
	
}
