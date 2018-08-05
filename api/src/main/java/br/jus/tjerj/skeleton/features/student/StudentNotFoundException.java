package br.jus.tjerj.skeleton.features.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2761084141068051723L;

	public StudentNotFoundException(String exception) {
		super(exception);
	}

}
