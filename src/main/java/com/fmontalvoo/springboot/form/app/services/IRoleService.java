package com.fmontalvoo.springboot.form.app.services;

import java.util.List;

import com.fmontalvoo.springboot.form.app.models.Role;

public interface IRoleService {

	public List<Role> listar();

	public Role obtenerPorId(Integer id);

}
