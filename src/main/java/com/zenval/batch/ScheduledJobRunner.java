package com.zenval.batch;

import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zenval.batch.core.JobQueue;

@Component
public class ScheduledJobRunner {

	@Autowired
	private JobQueue jobQueue;
	
	@Autowired
	private Job sampleJob;

	@Scheduled(fixedDelayString = "${batch.scheduler.jobFrequency}")
	public void getOptaMatchesJob() {
		jobQueue.enqueue(sampleJob);
	}
}
