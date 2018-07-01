package br.jus.tjerj.skeleton.domain.user;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;

import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebAuthentication;
import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebUser;
import br.jus.tjerj.skeleton.webapp.utils.controller.RestApiController;

@RestApiController
public class UserResource {	
	@GetMapping("/user")
	public SegwebUser retrieveUser(Principal principal) {
		return ((SegwebAuthentication) principal).getPrincipal();
	}
}
