package br.jus.tjerj.skeleton.features.user;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;

import br.jus.tjerj.skeleton.support.segweb.SegwebAuthentication;
import br.jus.tjerj.skeleton.support.segweb.SegwebUser;
import br.jus.tjerj.skeleton.support.utils.controller.RestApiController;

@RestApiController
public class UserResource {	
	@GetMapping("/user")
	public SegwebUser retrieveUser(Principal principal) {
		return ((SegwebAuthentication) principal).getPrincipal();
	}
}
