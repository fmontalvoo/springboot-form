package com.fmontalvoo.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class CapitalizeNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}

}
