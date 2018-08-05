package br.jus.tjerj.skeleton.configuration.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.tjerj.skeleton.support.segweb.SegwebAuthentication;
import br.jus.tjerj.skeleton.support.segweb.SegwebCredentials;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {     
	
	private AbstractJwtTokenService tokenService =  JwtTokenServiceFactory.getJwtTokenService();
	
	public JwtAuthenticationFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {

		SegwebCredentials creds = new ObjectMapper().readValue(req.getInputStream(), SegwebCredentials.class);

		return getAuthenticationManager().authenticate(new SegwebAuthentication(creds));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		tokenService.includeIntoResponse(res, auth);
	}
}