package br.jus.tjerj.skeleton.support.email;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.http.MediaType;

public abstract class Email {
	private String to;
	private String from;
	private String subject;
	private String message;
	private MediaType type;

	private static final String CHARSET_FIELD = ";charset=" + EmaiService.CHARSET;

	public Email(String to, String from, String subject, String message, MediaType type) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.message = message;
		this.type = type;
	}

	InternetAddress getTo() throws AddressException {
		return  new InternetAddress(to);
	}

	InternetAddress getFrom() throws AddressException {
		return new InternetAddress(from);
	}

	String getSubject() {
		return subject;
	}

	String getContent() {
		return message;
	}

	String getType() {
		return type.toString() + CHARSET_FIELD;
	}

}
