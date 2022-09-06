package com.fmontalvoo.springboot.form.app.models;

import javax.validation.constraints.NotEmpty;

public class UserForm {
	@NotEmpty
	private String email;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	public UserForm() {
	}

	public UserForm(@NotEmpty String email, @NotEmpty String username) {
		this.email = email;
		this.username = username;
	}

	public UserForm(@NotEmpty String email, @NotEmpty String username, @NotEmpty String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
