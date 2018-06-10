package br.jus.tjerj.skeleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringExtensionTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@BeforeEach
	void init() {
	    System.out.println("@BeforeEach - executes before each test method in this class");
	}
	
	@Test
	@Tag("Example")
	public void testMessage() {
		String message = this.restTemplate.getForObject("/environment", String.class);
		assertThat(message).contains("spring-boot");
	}

}