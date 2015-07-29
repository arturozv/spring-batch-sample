package com.zenval.batch.job.sample;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SampleTasklet implements Tasklet{
	private static Logger logger = Logger.getLogger(SampleTasklet.class);
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		logger.info("hello world tasklet spring batch");
		return RepeatStatus.FINISHED;
	}

}
