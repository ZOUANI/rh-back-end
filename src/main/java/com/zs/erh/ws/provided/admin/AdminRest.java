package com.zs.erh.ws.provided.admin;

import com.zs.erh.bean.Admin;
import com.zs.erh.bean.User;
import com.zs.erh.service.facade.AdminService;
import com.zs.erh.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "maneo-rh/admin/admin")
public class AdminRest {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @GetMapping("/login/{login}")
    public Optional<Admin> findBylogin(@PathVariable String login){
        return adminService.findByLogin(login);
    }
}
