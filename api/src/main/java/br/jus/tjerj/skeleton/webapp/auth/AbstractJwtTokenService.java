package br.jus.tjerj.skeleton.webapp.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebAuthentication;
import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebToken;
import br.jus.tjerj.skeleton.webapp.auth.segweb.SegwebUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public abstract class AbstractJwtTokenService {

	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	static final String CUSTOM_CLAIM = "data";

	protected abstract Object getPayload(Authentication auth);

	protected abstract Authentication createAuthentication(Object payload);

	public void includeIntoResponse(HttpServletResponse res, Authentication auth) {
		Object payload = getPayload(auth); 

		String JWT = Jwts.builder()
				.setSubject(auth.getName())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.claim(CUSTOM_CLAIM, payload)
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}

	public Authentication retrieveFromRequest(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);

		if (token == null) {
			return null;
		}

		Object payload = Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody()
				.get(CUSTOM_CLAIM, Object.class);
		
		if (payload == null) {
			return null;
		}

		return createAuthentication(payload);
	}

}