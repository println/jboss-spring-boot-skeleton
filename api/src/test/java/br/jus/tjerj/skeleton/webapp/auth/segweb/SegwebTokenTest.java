package br.jus.tjerj.skeleton.webapp.auth.segweb;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.jus.tjerj.skeleton.support.segweb.SegwebCredentials;
import br.jus.tjerj.skeleton.support.segweb.SegwebToken;
import br.jus.tjerj.skeleton.support.segweb.SegwebUser;

class SegwebTokenTest {
	
	private static String JSON = "{\"user\":{\"name\":\"name\",\"lastName\":\"lastname\"},\"credentials\":{\"code\":\"code\",\"system\":\"system\",\"token\":\"token\"}}";
	private SegwebToken token;
	
	@BeforeEach
	void setUp() {
		SegwebUser user = new SegwebUser("name", "lastname");
		SegwebCredentials credentials = new SegwebCredentials("code", "system", "token");
		this.token = new SegwebToken(user, credentials);
	}
	
	@Test
	void serializationTest() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String expected = objectMapper.writeValueAsString(token);		
		assertThat(JSON).isEqualTo(expected);
	}
	
	@Test
	void deserializationTest() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		SegwebToken expected = objectMapper.readValue(JSON, SegwebToken.class);		
		assertThat(token).isEqualTo(expected);
	}
}
