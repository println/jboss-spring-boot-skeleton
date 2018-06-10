package br.jus.tjerj.webapp.skeleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;


@ExtendWith(MockitoExtension.class)
class MockitoTests {

	@Mock
	private TestRestTemplate restTemplate;
	
	@BeforeEach
	void init() {
	    System.out.println("@BeforeEach - executes before each test method in this class");
	}
	
	@Test
	@Tag("Example")
	public void testMessage() {
		Mockito.when(restTemplate.getForObject("/environment", String.class)).thenReturn("spring-mock");
		
		String message = this.restTemplate.getForObject("/environment", String.class);
		assertThat(message).contains("spring-mock");
	}

}