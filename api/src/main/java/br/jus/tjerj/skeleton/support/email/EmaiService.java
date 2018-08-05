package br.jus.tjerj.skeleton.support.email;

import java.nio.charset.StandardCharsets;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmaiService {
	
	static final String CHARSET = StandardCharsets.UTF_8.name();
	
	public void send(Email email) throws MessagingException {
		Session session = null;
		MimeMessage message = new MimeMessage(session);
		message.setHeader("Content-Type", email.getType());
	    message.setSubject(email.getSubject(), CHARSET);
	    message.setContent(email.getContent(), email.getType());
	    
	    message.setFrom(new InternetAddress(email.getFrom())); //Remetente
	    
        Address[] toUser = InternetAddress.parse("seuamigo@gmail.com, seucolega@hotmail.com, seuparente@yahoo.com.br");  

        message.setRecipients(Message.RecipientType.TO, toUser);
	}

}
