package com.zs.erh.ws.provided.chef_agence;

import com.zs.erh.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "maneo-rh/chef-agence/user")
public class UserChefAgenceRest {

    @Autowired
    private UserService userService;

    @GetMapping("/block/id/{id}")
    public int block(@PathVariable Long id) {
        return userService.block(id);
    }
    @GetMapping("/reset/ide/{ide}")
    public int reset(@PathVariable Long ide) {
        return userService.reset(ide);
    }
    @GetMapping("/deblock/idi/{idi}")
    public int deblock( @PathVariable Long idi) {
        return userService.deblock(idi);
    }
}
