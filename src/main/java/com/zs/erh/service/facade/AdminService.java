package com.zs.erh.service.facade;

import com.zs.erh.bean.Admin;

import java.util.Optional;

public interface AdminService {
	Optional<Admin> findByLogin (String login);

	Boolean existsByLogin(String login);

	Boolean existsByEmail(String email);

	public Admin save (Admin user);
}
