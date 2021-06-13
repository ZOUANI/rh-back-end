package com.zs.erh.security.services;


import com.zs.erh.bean.User;
import com.zs.erh.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userDao.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + login));

		return UserDetailsImpl.build(user);
	}

}
