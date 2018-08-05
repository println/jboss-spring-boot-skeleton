package br.jus.tjerj.skeleton.support.email;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailResource {

	@Autowired
	private EmailService emailService;

	@PostMapping
	public String retrieveEnvironment(@Valid @RequestBody String message) {
		Email email = new HtmlEmail("fulano@a.com", "fulano@b.com", "Assunto", message);
		try {
			emailService.send(email);
			return "sucesso";
		} catch (Exception e) {
			return "falha" + e.getMessage();
		}
	}
}
