package br.jus.tjerj.webapp.skeleton;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJndi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class Config {
	
	@Bean
	@ConditionalOnJndi
	public DataSource dataSource() 
	{
	  JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	  DataSource dataSource = dataSourceLookup.getDataSource("java:jboss/datasources/ExampleDS");
	  System.out.println("SPRING-BOOT: OBTENDO DATASOURCE DO JBOSS");
	  return dataSource;
	}
}
