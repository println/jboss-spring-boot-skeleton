package br.jus.tjerj.skeleton.support.email;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.http.MediaType;

public class Email {
	private String to;
	private String from;
	private String subject;
	private String content;
	private MediaType type;
	private List<String> cc;
	private List<String> bcc;
	private List<String> replyTo;

	private static final String CHARSET_FIELD = ";charset=" + EmailService.CHARSET;

	public Email(String to, String from, String subject, String content, MediaType type) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.content = content;
		this.type = type;
	}

	public InternetAddress getToAddress() throws AddressException {
		return new InternetAddress(to);
	}

	public InternetAddress getFromAddress() throws AddressException {
		return new InternetAddress(from);
	}

	public InternetAddress[] getReplyToAddresses() throws AddressException {
		if (replyTo == null) {
			return null;
		}
		return emailToInternetAddress(replyTo);
	}

	public InternetAddress[] getCcAddresses() throws AddressException {
		if (cc == null) {
			return null;
		}
		return emailToInternetAddress(cc);
	}

	public InternetAddress[] getBccAddresses() throws AddressException {
		if (bcc == null) {
			return null;
		}
		return emailToInternetAddress(bcc);
	}

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public String getContent() {
		return content;
	}

	public String getSubject() {
		return subject;
	}

	public String getContentType() {
		return type.toString() + CHARSET_FIELD;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public List<String> getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(List<String> replyTo) {
		this.replyTo = replyTo;
	}

	public MediaType getType() {
		return type;
	}

	public boolean hasReplyTo() {
		return hasList(replyTo);
	}

	public boolean hasCc() {
		return hasList(cc);
	}

	public boolean hasBcc() {
		return hasList(bcc);
	}

	private InternetAddress[] emailToInternetAddress(List<String> emails) throws AddressException {
		List<InternetAddress> addresses = new ArrayList<>();
		for (String to : emails) {
			addresses.add(new InternetAddress(to));
		}
		return (InternetAddress[]) addresses.toArray();
	}

	private boolean hasList(List<String> list) {
		return list != null && !list.isEmpty();
	}

}
