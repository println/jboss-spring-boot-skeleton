package br.jus.tjerj.skeleton.support.segweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class SegwebAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private SegwebService service; 
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SegwebAuthentication token = (SegwebAuthentication) authentication;
		
		SegwebCredentials credentials = token.getCredentials();
		
		SegwebUser user = new SegwebUser(credentials.getCode(),credentials.getSystem());		
		
		return new SegwebAuthentication(user, credentials);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(SegwebAuthentication.class);
	}

}
