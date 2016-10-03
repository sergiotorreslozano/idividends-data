package com.idividends.data.config;


import java.net.URI;
import java.net.URISyntaxException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Database configuration class. It will be dependant of the environment
 * variable DATABASE_URL, which contain all the information regarding the
 * connection to the Database: user/password/url/protocol
 *
 */
@Configuration
public class DatabaseConfig {

	private final static Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	private final static int USER_PASSWORD_PARAMS = 2;

	@Bean
	@Profile("default")
	public DataSource dataSource() {
		String databaseUrl = System.getenv("DATABASE_URL");
		URI dbUri;
		try {
			dbUri = new URI(databaseUrl);
		} catch (URISyntaxException e) {
			logger.error("databaseUrl cannot be null");
			return null;
		}

		// For travis, as DB has no password.
		String username = dbUri.getUserInfo().split(":")[0];
		String password = null;
		if (USER_PASSWORD_PARAMS == dbUri.getUserInfo().split(":").length) {
			password = dbUri.getUserInfo().split(":")[1];
		}

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		logger.debug("Data base properties --> dbUrl: " + dbUrl + " username: " + username);
		logger.debug("SPRING_JPA_HIBERNATE_DDL_AUTO: " + System.getenv("SPRING_JPA_HIBERNATE_DDL_AUTO"));
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		String driverClassName = System.getenv("DRIVER_CLASS_NAME") != null ? System.getenv("DRIVER_CLASS_NAME")
				: "org.postgresql.Driver";
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		if (password != null && !password.isEmpty()) {
			dataSource.setPassword(password);
		}
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnReturn(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	@Bean
	@Profile("default")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean(destroyMethod = "close")
	@Profile("test")
	public DataSource h2dataSource() {
		String DATABASE_URL = "jdbc:h2:mem:;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;DB_CLOSE_ON_EXIT=FALSE;INIT=create schema if not exists public;";
		logger.debug("Loading in memory data base with parameters: " + DATABASE_URL);
		logger.debug("SPRING_JPA_HIBERNATE_DDL_AUTO: " + System.getenv("SPRING_JPA_HIBERNATE_DDL_AUTO"));
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl(DATABASE_URL);
		ds.setUsername("sa");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		ds.setMaxIdle(5);
		ds.setMinIdle(2);
		return ds;
	}

	@Bean
	@Profile("test")
	public JdbcOperations tpl() {
		return new JdbcTemplate(h2dataSource());
	}

}