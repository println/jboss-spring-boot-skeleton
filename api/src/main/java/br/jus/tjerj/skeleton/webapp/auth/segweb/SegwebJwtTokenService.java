package br.jus.tjerj.skeleton.webapp.auth.segweb;

import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.tjerj.skeleton.webapp.auth.AbstractJwtTokenService;

public class SegwebJwtTokenService extends AbstractJwtTokenService {

	@Override
	protected Object getPayload(Authentication auth) {
		SegwebAuthentication authentication = (SegwebAuthentication) auth;
		return authentication.getToken();
	}

	@Override
	protected Authentication createAuthentication(Object payload) {
		SegwebToken token = new ObjectMapper().convertValue(payload, SegwebToken.class);
		SegwebAuthentication authentication = new SegwebAuthentication(token);
		authentication.setAuthenticated(true);
		return authentication;
	}

}