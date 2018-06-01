package br.jus.tjerj.webapp.skeleton;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJndi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class Config {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

	@Bean
	@ConditionalOnJndi
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource("java:jboss/datasources/ExampleDS");
		LOGGER.info("[DATASOURCE] java:jboss/datasources/ExampleDS");
		return dataSource;
	}	
}
