package com.zs.erh.ws;

import com.zs.erh.bean.MembreEquipe;
import com.zs.erh.service.MembreEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembreEquipeRest {
    @Autowired
    private MembreEquipeService membreEquipeService;

    @GetMapping("/")
    public List<MembreEquipe> findAll(){
        return membreEquipeService.findAll();
    }



}
