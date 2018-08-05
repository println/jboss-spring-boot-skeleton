package br.jus.tjerj.skeleton.support.email;

import org.springframework.http.MediaType;

public class HtmlEmail extends Email {

	public HtmlEmail(String to, String from, String subject, String content) {
		super(to, from, subject, content, MediaType.TEXT_HTML);
	}

}
