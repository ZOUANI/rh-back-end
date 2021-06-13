package com.zs.erh.dao;


import com.zs.erh.bean.Role;
import com.zs.erh.service.util.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository <Role,Long> {
    Optional<Role> findByName(Roles name);

}
