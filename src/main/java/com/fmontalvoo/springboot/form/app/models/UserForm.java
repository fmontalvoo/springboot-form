package com.fmontalvoo.springboot.form.app.models;

import java.util.Date;
import java.util.List;

//import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

import com.fmontalvoo.springboot.form.app.validators.IdentifierRegex;
import com.fmontalvoo.springboot.form.app.validators.RequiredField;

public class UserForm {

//	@Pattern(regexp = "^0[\\d]{9}")
	@IdentifierRegex
	private String id;

	@Email
	@NotEmpty(message = "El email es obligatorio")
	private String email;

	@Min(18)
	@Max(65)
	@NotNull
	private Integer edad;

	@Past
	@NotNull
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

	@NotEmpty
	private String genero;

//	@Valid
	@NotNull
	private Pais pais;

//	@NotEmpty
	@Size(message = "El nombre de usuario debe tener entre 3 y 8 caracteres", min = 3, max = 8)
	private String username;

	@NotEmpty
	private List<Role> roles;

//	@NotBlank
	@RequiredField
	private String password;

	private Boolean activar;

	private String secreto;

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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivar() {
		return activar;
	}

	public void setActivar(Boolean activar) {
		this.activar = activar;
	}

	public String getSecreto() {
		return secreto;
	}

	public void setSecreto(String secreto) {
		this.secreto = secreto;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", email=" + email + ", edad=" + edad + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + ", pais=" + pais + ", username=" + username + ", roles=" + roles
				+ ", password=" + password + ", activar=" + activar + ", secreto=" + secreto + "]";
	}

}
