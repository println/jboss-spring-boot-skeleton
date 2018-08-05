package br.jus.tjerj.skeleton.configuration.config;

import javax.mail.Session;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJndi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@Profile("prod")
public class JbossConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(JbossConfig.class);
	private static final String TITLE = "**JBOSS-BEAN**";

	@Bean
	@ConditionalOnJndi
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource("java:jboss/datasources/ExampleDS");
		LOGGER.info(TITLE + "[DATASOURCE] java:jboss/datasources/ExampleDS");
		return dataSource;
	}

	@Bean
	@ConditionalOnJndi
	public JavaMailSender jbossEmailSession() throws NamingException {
		JndiTemplate template = new JndiTemplate();
		Session mailSession = (Session) template.lookup("java:jboss/mail/Default");
		LOGGER.info(TITLE + "[Email Session] java:jboss/mail/Default");

		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setSession(mailSession);
		return mailSenderImpl;
	}
}
