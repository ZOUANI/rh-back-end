package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Admin;
import com.zs.erh.service.facade.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "maneo-rh/admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public Admin findBylogin(@PathVariable String login){
        return this.adminService.findByLogin(login);
    }

}
