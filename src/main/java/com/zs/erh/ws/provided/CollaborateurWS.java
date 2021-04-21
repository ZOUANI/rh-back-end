package com.zs.erh.ws.provided;

import java.util.List;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "maneo-rh/collaborateur")
public class CollaborateurWS
 {
	@Autowired
	private CollaborateurService collaborateurService;

	@GetMapping("/")
	public List<Collaborateur> findAll() {
		return collaborateurService.findAll();
	}

	@GetMapping("/code/{code}")
	public Collaborateur findByCode(String code) {
		return collaborateurService.findByCode(code);
	}

}
