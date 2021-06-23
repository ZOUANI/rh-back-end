package com.zs.erh.ws.provided.general;

import com.zs.erh.bean.Agence;
import com.zs.erh.service.facade.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("maneo-rh/general/agence")
public class AgenceRest {
    @Autowired
    private AgenceService agenceService;
    @GetMapping("/codev/{codev}")
    public List<Agence> findByVilleCode(@PathVariable String codev) {
        return agenceService.findByVilleCode(codev);
    }
    @GetMapping("/")
    public List<Agence> findAll() {
        return agenceService.findAll();
    }
}
