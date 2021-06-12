package com.zs.erh.security.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String login;

	@NotBlank
	private String password;

	private String connect_as;


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConnect_as() {
		return connect_as;
	}

	public void setConnect_as(String connect_as) {
		this.connect_as = connect_as;
	}

}
