package com.fmontalvoo.springboot.form.app.services;

import java.util.List;

import com.fmontalvoo.springboot.form.app.models.Pais;

public interface IPaisService {

	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
	
}
