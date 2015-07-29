package com.zenval.batch.job.sample;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class SampleReader implements ItemReader<String>{
	private AtomicInteger counter;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return (counter.decrementAndGet() > 0) ? "Hello" : null;
	}

	@BeforeStep
	public void reset(){
		counter = new AtomicInteger(10);
	}
	
}
