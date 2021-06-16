package com.zs.erh.ws.provided.chef_equipe;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "maneo-rh/chef-equipe/collaborateur")
public class CollaborateurCERest {
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

	@GetMapping("/login/{login}/password/{password}")
	public Collaborateur findByLoginAndPassword(@PathVariable String login,@PathVariable String password){
		return collaborateurService.findByLoginAndPassword(login,password);
	}
	@PostMapping("/signIn")
	public Collaborateur sauthentifier(@RequestBody Collaborateur collaborateur){
		return collaborateurService.signIn(collaborateur);
	}
	@PostMapping("/connexion")
	public Collaborateur connexionChefEquipe(@RequestBody Collaborateur collaborateur){
		return collaborateurService.connexionChefEquipe(collaborateur);
	}

	@GetMapping("/findCollaborateurs/{login}")
	public List<Collaborateur> findCollaborateurs(@PathVariable String login){
		return collaborateurService.findCollaborateurs(login);
	}


		@Autowired
	 private CollaborateurService collaborateurService;

}
