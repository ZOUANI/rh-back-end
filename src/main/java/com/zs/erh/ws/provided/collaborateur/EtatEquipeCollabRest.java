package com.zs.erh.ws.provided.collaborateur;

import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.service.facade.EtatEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "maneo-rh/collaborateur/etatequipe")
public class EtatEquipeCollabRest {
	@Autowired
	private EtatEquipeService etatEquipeService;

	
	@GetMapping("/")
	public List<EtatEquipe> findAll() {
		return etatEquipeService.findAll();
	}
	
//	
}
