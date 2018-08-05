package br.jus.tjerj.skeleton.support.email;

import java.nio.charset.StandardCharsets;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

	static final String CHARSET = StandardCharsets.UTF_8.name();

	@Autowired
	public JavaMailSender emailSender;

	public void send(Email email) {
		MimeMessage message = this.createMessage(email);
		this.send(message);
	}

	private void send(MimeMessage message) {
		try {
			emailSender.send(message);
		} catch (Exception e) {
			LOGGER.error("Falha ao enviar email.", e);
			throw e;
		}
	}

	private MimeMessage createMessage(Email email) {
		try {
			return createMimeMessage(email);
		} catch (AddressException e) {
			LOGGER.error("Falha ao criar enderecos de email.", e);
		} catch (MessagingException e) {
			LOGGER.error("Falha ao definir os campos do email.", e);
		}
		throw new RuntimeException("Falha na criacao do email.");
	}

	private MimeMessage createMimeMessage(Email email) throws MessagingException, AddressException {
		MimeMessage message = emailSender.createMimeMessage();

		message.setHeader("Content-Type", email.getContentType());
		message.setSubject(email.getSubject(), CHARSET);
		message.setContent(email.getContent(), email.getContentType());

		message.setFrom(email.getFromAddress());
		message.setRecipient(Message.RecipientType.TO, email.getToAddress());

		if (email.hasBcc()) {
			message.setRecipients(Message.RecipientType.BCC, email.getBccAddresses());
		}

		if (email.hasCc()) {
			message.setRecipients(Message.RecipientType.CC, email.getCcAddresses());
		}

		if (email.hasReplyTo()) {
			message.setReplyTo(email.getReplyToAddresses());
		}
		return message;
	}

}
