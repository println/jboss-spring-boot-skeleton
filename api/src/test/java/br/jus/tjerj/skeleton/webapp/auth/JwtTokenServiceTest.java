package br.jus.tjerj.skeleton.webapp.auth;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.tjerj.skeleton.support.segweb.SegwebCredentials;
import br.jus.tjerj.skeleton.support.segweb.SegwebToken;
import br.jus.tjerj.skeleton.support.segweb.SegwebUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class JwtTokenServiceTest {
	private SegwebToken token;
	@BeforeEach
	void setUp() {
		SegwebUser user = new SegwebUser("name", "lastname");
		SegwebCredentials credentials = new SegwebCredentials("code", "system", "token");
		this.token = new SegwebToken(user, credentials);
	}

	@Test
	void test() {
		String JWT = Jwts.builder()
				.setSubject("teste")
				.setExpiration(new Date(System.currentTimeMillis() + 10000L))
				.claim("data",token)
				.signWith(SignatureAlgorithm.HS512, "secret").compact();
		
		System.out.println(JWT);
		
		Object obj = Jwts.parser()
			.setSigningKey("secret")
			.parseClaimsJws(JWT)
			.getBody()
			.get("data", Object.class);
		
		
		SegwebToken tok = new ObjectMapper().convertValue(obj, SegwebToken.class);
		System.out.println(tok);
	}

}
