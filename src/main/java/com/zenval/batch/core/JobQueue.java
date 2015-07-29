package com.zenval.batch.core;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zenval.util.TimeDuration;

@Component
public class JobQueue {
	private static Logger logger = Logger.getLogger(JobQueue.class);

	@Autowired
	private CustomJobLauncher jobLauncher;

	private BlockingQueue<Job> jobQueue = new ArrayBlockingQueue<Job>(1000);

	public void enqueue(Job job) {
		if (jobQueue.remainingCapacity() > 0) {
			logger.info("Job " + job.getName() + " added to execution queue");
			jobQueue.add(job);
		} else {
			logger.warn("Job queue is FULL!!");
		}
	}

	@Scheduled(fixedDelay = 1)
	public void executeJobQueue() {
		try {
			Job job = jobQueue.poll(5, TimeUnit.MINUTES);
			if (job != null) {
				Instant start = Instant.now();
				logger.info("got a job from  the queue to execute: " + job.getName() + ". Queue size: " + jobQueue.size());
				jobLauncher.executeJob(job);
				logger.info("Job " + job.getName() + " executed in " + TimeDuration.getMillisSince(start) + "ms\n");
			}
		} catch (InterruptedException ie) {
		}
	}
}
