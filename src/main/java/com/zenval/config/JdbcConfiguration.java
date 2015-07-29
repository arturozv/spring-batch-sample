package com.zenval.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class JdbcConfiguration {

	@Autowired
	private JdbcConfigurationProperties properties;

	/**
	 * MySQL Configuration @see https://github.com/brettwooldridge/HikariCP/wiki/MySQL-Configuration
	 */
	@Bean
	public DataSource dataSource() {

		HikariConfig config = new HikariConfig();

		config.setUsername(properties.getUserName());
		config.setPassword(properties.getPassword());

		config.setDataSourceClassName(properties.getDataSourceClassName());
		config.setMaximumPoolSize(properties.getMaximumPoolSize());

		config.addDataSourceProperty("serverName", properties.getServerName());
		config.addDataSourceProperty("portNumber", properties.getPortNumber());
		config.addDataSourceProperty("databaseName", properties.getDatabaseName());

		config.addDataSourceProperty("cachePrepStmts", properties.getCachePrepStmts());
		config.addDataSourceProperty("prepStmtCacheSize", properties.getPrepStmtCacheSize());
		config.addDataSourceProperty("prepStmtCacheSqlLimit", properties.getPrepStmtCacheSqlLimit());

		config.addDataSourceProperty("characterEncoding", "UTF-8");
		config.setPoolName("Hikari-Pool");

		return new HikariDataSource(config);
	}
}
