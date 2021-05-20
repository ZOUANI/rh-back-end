package com.zs.erh.service.facade;

import com.zs.erh.bean.Admin;

public interface AdminService {
	public Admin findByLogin(String login);
	public int save(Admin admin);
}
