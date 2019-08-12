package com.breakbot.media.step;

import org.springframework.batch.item.ItemProcessor;

public class FileProcessor implements ItemProcessor<String, String>{

	@Override
	public String process(String content) throws Exception {
		return content.toUpperCase();
	}
}