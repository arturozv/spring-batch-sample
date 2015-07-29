package com.zenval.batch.job.sample;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class SampleJobConfiguration {
	private final int commitInterval = 100;
	private final int maxThreads = 2;
	
	@Autowired
    private JobBuilderFactory jobs;
	
    @Autowired
    private StepBuilderFactory stepBuilder;

    private TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(maxThreads);
        taskExecutor.setCorePoolSize(maxThreads);
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }

    @Bean
    public Job sampleJob(Step sampleTaskletStep, Step sampleChunkStep){
        Job job = jobs.get("sampleJob")
                .start(sampleTaskletStep)
                .next(sampleChunkStep)
                .build();
       return job;
    }

    @Bean
    public Step sampleTaskletStep(SampleTasklet sampleTasklet) {
    	return stepBuilder.get("sampleTaskletStep").tasklet(sampleTasklet).build();
    }
    
    @Bean
    public Step sampleChunkStep(SampleReader reader, SampleProcessor processor, SampleWriter writer){
    	return stepBuilder.get("sampleChunkStep").
                <String, String>chunk(commitInterval)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .taskExecutor(taskExecutor())
                .throttleLimit(maxThreads)
                .build();
    }
}
