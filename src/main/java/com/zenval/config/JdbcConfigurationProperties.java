package com.zenval.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * Database configuration
 * @see http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
 */
@Component
@ConfigurationProperties(prefix = "dataSource")
public class JdbcConfigurationProperties {

    private String userName;
    private String password;
    private String dataSourceClassName;
    private Integer maximumPoolSize;
    private String serverName;
    private Integer portNumber;
    private String databaseName;

    /* Tunning */
    private String cachePrepStmts;
    private String prepStmtCacheSize;
    private String prepStmtCacheSqlLimit;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDataSourceClassName() {
		return dataSourceClassName;
	}
	public void setDataSourceClassName(String dataSourceClassName) {
		this.dataSourceClassName = dataSourceClassName;
	}
	public Integer getMaximumPoolSize() {
		return maximumPoolSize;
	}
	public void setMaximumPoolSize(Integer maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public Integer getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(Integer portNumber) {
		this.portNumber = portNumber;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	public String getCachePrepStmts() {
		return cachePrepStmts;
	}
	public void setCachePrepStmts(String cachePrepStmts) {
		this.cachePrepStmts = cachePrepStmts;
	}
	public String getPrepStmtCacheSize() {
		return prepStmtCacheSize;
	}
	public void setPrepStmtCacheSize(String prepStmtCacheSize) {
		this.prepStmtCacheSize = prepStmtCacheSize;
	}
	public String getPrepStmtCacheSqlLimit() {
		return prepStmtCacheSqlLimit;
	}
	public void setPrepStmtCacheSqlLimit(String prepStmtCacheSqlLimit) {
		this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JdbcConfigurationProperties [userName=").append(userName).append(", password=").append("****").append(", dataSourceClassName=").append(dataSourceClassName)
				.append(", maximumPoolSize=").append(maximumPoolSize).append(", serverName=").append(serverName).append(", portNumber=").append(portNumber).append(", databaseName=")
				.append(databaseName).append(", cachePrepStmts=").append(cachePrepStmts).append(", prepStmtCacheSize=").append(prepStmtCacheSize).append(", prepStmtCacheSqlLimit=")
				.append(prepStmtCacheSqlLimit).append("]");
		return builder.toString();
	}
    
}
