package br.jus.tjerj.skeleton.support.serverinfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerInfoResource {

	@Value("${environment}")
	private String environment;

	@GetMapping("/environment")
	public String retrieveEnvironment() {
		return environment;
	}
}
