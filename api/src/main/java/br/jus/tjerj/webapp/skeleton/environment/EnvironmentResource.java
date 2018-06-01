package br.jus.tjerj.webapp.skeleton.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentResource {

	@Value("${environment}")
	private String environment;

	@GetMapping("/environment")
	public String retrieveEnvironment() {
		return environment;
	}
}
