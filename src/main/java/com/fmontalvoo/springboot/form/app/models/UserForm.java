package com.fmontalvoo.springboot.form.app.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {

	private String id;

	@Email
	@NotEmpty(message = "El email es obligatorio")
	private String email;

	@NotEmpty
	@Size(message = "El nombre de usuario debe tener entre 3 y 8 caracteres", min = 3, max = 8)
	private String username;

	@NotEmpty
	private String password;

	public UserForm() {
	}

	public UserForm(@NotEmpty String email, @NotEmpty String username) {
		this.email = email;
		this.username = username;
	}

	public UserForm(String id, @NotEmpty String email, @NotEmpty String username, @NotEmpty String password) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
