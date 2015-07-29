package com.zenval.batch.core;

public class JobResult {

	private String name;
	private Long jobId;
	private String status;
	private Long duration;
	private String exitDescription;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getExitDescription() {
		return exitDescription;
	}
	public void setExitDescription(String exitDescription) {
		this.exitDescription = exitDescription;
	}
	@Override
	public String toString() {
		return "JobResult [name=" + name + ", jobId=" + jobId + ", status=" + status + ", duration=" + duration + ", exitDescription=" + exitDescription + "]";
	}
}
