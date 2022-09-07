package com.fmontalvoo.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fmontalvoo.springboot.form.app.models.Role;

@Service
public class RoleService implements IRoleService {

	private List<Role> roles;

	public RoleService() {
		this.roles = Arrays.asList(new Role(1, "Usuario", "ROLE_USER"), new Role(2, "Administrador", "ROLE_ADMIN"),
				new Role(3, "Editor", "ROLE_EDITOR"));
	}

	@Override
	public List<Role> listar() {
		return this.roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		for (Role role : roles) {
			if (role.getId() == id)
				return role;
		}
		return null;
	}

}
