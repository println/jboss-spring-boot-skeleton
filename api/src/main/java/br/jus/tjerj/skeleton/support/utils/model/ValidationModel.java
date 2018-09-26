package br.jus.tjerj.skeleton.support.utils.model;

import java.io.Serializable;

public class ValidationModel<T extends Serializable> {

	private T model;

	private Boolean isValid = false;

	private String errorMesssages;

	public String getErrorMesssages() {
		return this.errorMesssages;
	}

	public void setErrorMesssages(String errorMesssages) {
		this.errorMesssages = errorMesssages;
	}

	public T getModel() {
		return this.model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public Boolean isValid() {
		return this.isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
