package com.zenval.batch.job.sample;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SampleProcessor implements ItemProcessor<String, String> {

	@Override
    public String process(String text) throws Exception {
		return text + " world";
	}
}
