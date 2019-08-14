package com.breakbot.media.step;

import com.breakbot.media.model.MediaFile;
import org.springframework.batch.item.ItemProcessor;

public class FileProcessor implements ItemProcessor<MediaFile, MediaFile>{

	@Override
	public MediaFile process(MediaFile content) throws Exception {
		System.out.println(content.toString());
		return content;
	}
}