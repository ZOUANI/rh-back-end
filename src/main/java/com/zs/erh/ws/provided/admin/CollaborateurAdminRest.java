package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "maneo-rh/admin/collaborateur")
public class CollaborateurAdminRest {
	@GetMapping("/id/{id}")
	 public Optional<Collaborateur> findById(@PathVariable Long id) {
		 return collaborateurService.findById(id);
	 }

	@GetMapping("/login/{login}")
	public Collaborateur findByLogin(@PathVariable String login) {
		return collaborateurService.findByLogin(login);
	}

	@GetMapping("/")
	public List<Collaborateur> findAll() {
		return collaborateurService.findAll();
	}

	@GetMapping("/code/{code}")
	public Collaborateur findByCode(@PathVariable String code) {
		return collaborateurService.findByCode(code);
	}

    @GetMapping("codec/codec")
	public List<Collaborateur> findByAgenceChefAgenceCode(@PathVariable String codec) {
		return collaborateurService.findByAgenceChefAgenceCode(codec);
	}

	@Autowired
	 private CollaborateurService collaborateurService;

}
