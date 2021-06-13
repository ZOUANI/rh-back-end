package com.zs.erh.ws.provided;

import java.util.List;
import java.util.Optional;

import com.zs.erh.bean.Collaborateur;
import com.zs.erh.service.facade.CollaborateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "maneo-rh/collaborateur")
public class CollaborateurWS{
	@GetMapping("/id/{id}")
	 public Optional<Collaborateur> findById(@PathVariable Long id) {
		 return collaborateurService.findById(id);
	 }

	@GetMapping("/login/{login}")
	public Collaborateur findByLogin(@PathVariable String login) {
		return collaborateurService.findByLogin(login);
	}
	/*@PostMapping("/")
	public int save(@RequestBody Collaborateur collaborateur) {
		return collaborateurService.save(collaborateur);
	}*/

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
	@PostMapping("/")
	public Collaborateur sinscrire(@RequestBody Collaborateur collaborateur) {
		return collaborateurService.saveCollaborateur(collaborateur);
	}
	@PostMapping("/signIn")
	public Collaborateur sauthentifier(@RequestBody Collaborateur collaborateur){
		return collaborateurService.signIn(collaborateur);
	}
	@PostMapping("/connexion")
	public Collaborateur connexionChefEquipe(@RequestBody Collaborateur collaborateur){
		return collaborateurService.connexionChefEquipe(collaborateur);
	}
    @GetMapping("codec/codec")
	public List<Collaborateur> findByAgenceChefAgenceCode(@PathVariable String codec) {
		return collaborateurService.findByAgenceChefAgenceCode(codec);
	}

	@Autowired
	 private CollaborateurService collaborateurService;

}
