package com.fmontalvoo.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fmontalvoo.springboot.form.app.services.IPaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private IPaisService paisService;

	@Override
	public void setAsText(String value) throws IllegalArgumentException {
		if (value != null && !value.isBlank()) {
			Integer id = Integer.parseInt(value);
			this.setValue(paisService.obtenerPorId(id));
		}
	}

}
