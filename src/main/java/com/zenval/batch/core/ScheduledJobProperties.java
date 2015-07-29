package com.zenval.batch.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * ScheduledJobProperties
 * @see http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
 */
@Component
@ConfigurationProperties(prefix = "batch.scheduler")
public class ScheduledJobProperties {

    private boolean enabled;
    private String jobFrequency;
    
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getJobFrequency() {
		return jobFrequency;
	}
	public void setJobFrequency(String jobFrequency) {
		this.jobFrequency = jobFrequency;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScheduledJobProperties [enabled=").append(enabled).append(", jobFrequency=").append(jobFrequency).append("]");
		return builder.toString();
	}
}
