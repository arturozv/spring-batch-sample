package com.zenval.batch.job.sample;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class SampleWriter implements ItemWriter<String> {
	private static Logger logger = Logger.getLogger(SampleWriter.class);
	
	@Override
	public void write(List<? extends String> all) throws Exception {
		for(String text: all){
			logger.info(text + " spring batch!");
		}
	}
}
