package com.fmontalvoo.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fmontalvoo.springboot.form.app.services.IRoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {

	@Autowired
	private IRoleService roleService;

	@Override
	public void setAsText(String value) throws IllegalArgumentException {
		if (value != null && !value.isBlank()) {
			Integer id = Integer.parseInt(value);
			this.setValue(roleService.obtenerPorId(id));
		}
	}

}
