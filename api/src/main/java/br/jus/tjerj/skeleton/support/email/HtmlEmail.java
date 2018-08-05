package br.jus.tjerj.skeleton.support.email;

import org.springframework.http.MediaType;

public class HtmlEmail extends Email {

	public HtmlEmail(String to, String from, String subject, String message) {
		super(to, from, subject, message, MediaType.TEXT_HTML);
	}

}
