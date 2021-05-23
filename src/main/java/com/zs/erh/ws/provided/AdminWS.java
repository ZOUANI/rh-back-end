package com.zs.erh.ws.provided;

import com.zs.erh.bean.Admin;
import com.zs.erh.service.facade.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "maneo-rh/admin")
public class AdminWS {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login/{login}")
    public Admin findByLogin(@PathVariable String login) {
        return adminService.findByLogin(login);
    }

    @PostMapping("/")
    public int save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PostMapping("/seconnecter")
    public Admin SeConnecter(@RequestBody Admin admin) {
        return adminService.SeConnecter(admin);
    }
}
