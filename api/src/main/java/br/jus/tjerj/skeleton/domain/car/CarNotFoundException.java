package br.jus.tjerj.skeleton.domain.car;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2761084141068051723L;

	public CarNotFoundException(String exception) {
		super(exception);
	}

}
