package com.zenval.batch.core;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomJobLauncher {
	private static Logger logger = Logger.getLogger(CustomJobLauncher.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private ScheduledJobProperties scheduledJobProperties;

	public JobResult executeJob(Job job) {
		JobResult jobResult;
		JobExecution execution = null;
		long jobId = System.nanoTime();

		try {
			if (jobsEnabled()) {
				logger.info("Launching job " + job.getName() + ". Id: " + jobId);
				execution = jobLauncher.run(job, new JobParametersBuilder().addLong("run.id", jobId).toJobParameters());
			}
		} catch (Exception e) {
			logger.error("Error while executing job " + job.getName(), e);
		} finally {
			jobResult = getJobResult(job, execution, jobId);
		}
		
		if (jobsEnabled()) {
			logger.info("Job finished. Result: " + jobResult);
		}
		return jobResult;
	}

	private JobResult getJobResult(Job job, JobExecution execution, long jobId) {
		JobResult result = new JobResult();
		result.setName(job.getName());
		result.setJobId(jobId);
		if (jobsEnabled()) {
			if (execution != null) {
				if (execution.getStatus() != null) {
					result.setStatus(execution.getStatus().toString());
				}
				if (execution.getStartTime() != null && execution.getEndTime() != null) {
					result.setDuration(execution.getEndTime().getTime() - execution.getStartTime().getTime());
				}
				if (execution.getExitStatus() != null) {
					result.setExitDescription(execution.getExitStatus().getExitDescription());
				}
			}
		} else {
			result.setStatus("BATCH_DISABLED");
			result.setDuration(0l);
		}
		return result;
	}

	private boolean jobsEnabled() {
		return scheduledJobProperties.isEnabled();
	}
}
