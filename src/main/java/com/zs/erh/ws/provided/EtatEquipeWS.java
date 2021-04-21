package com.zs.erh.ws.provided;

import java.util.List;

import com.zs.erh.bean.EtatEquipe;
import com.zs.erh.service.facade.EtatEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "maneo-rh/etatequipe")
public class EtatEquipeWS {
	@Autowired
	private EtatEquipeService etatEquipeService;

	
	@GetMapping("/")
	public List<EtatEquipe> findAll() {
		return etatEquipeService.findAll();
	}
	
//	
}
