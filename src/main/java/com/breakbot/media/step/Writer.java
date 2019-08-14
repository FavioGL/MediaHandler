package com.breakbot.media.step;

import java.util.List;

import com.breakbot.media.model.MediaFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<MediaFile> {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void write(List<? extends MediaFile> messages) throws Exception {
		for(MediaFile msg : messages){
			System.out.println("#Writer Step: " + msg);
		}
	}
	
}