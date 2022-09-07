package com.fmontalvoo.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fmontalvoo.springboot.form.app.models.Pais;

@Service
public class PaisService implements IPaisService {

	private List<Pais> paises;

	public PaisService() {
		this.paises = Arrays.asList(new Pais(1, "EC", "Ecuador"), new Pais(2, "CO", "Colombia"),
				new Pais(3, "PE", "Perú"), new Pais(4, "BO", "Bolivia"), new Pais(5, "VE", "Venezuela"));
	}

	@Override
	public List<Pais> listar() {
		return this.paises;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		for (Pais pais : paises) {
			if (pais.getId() == id)
				return pais;
		}
		return null;
	}

}
