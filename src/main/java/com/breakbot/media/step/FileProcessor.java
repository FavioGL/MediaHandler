package com.breakbot.media.step;

import com.breakbot.media.model.MediaFile;
import com.breakbot.media.model.MediaList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FileProcessor implements ItemProcessor<MediaFile, MediaFile>{
	private static final Logger logger = LogManager.getLogger(FileProcessor.class);

	@Autowired
	private MediaList mediaList;

	@Override
	public MediaFile process(MediaFile content) throws Exception {
		logger.info(mediaList);

		if(!mediaList.getFileList().contains(content)){
			logger.info("Adding: " + content.toString());
			mediaList.getFileList().add(content);
		}else{
			if(!mediaList.getDuplicatedList().contains(content)){
				logger.info("Adding DUPLICATED: " + content.toString());
				mediaList.getDuplicatedList().add(content);
			}else {
				logger.info("DISCARDED: " + content.toString());
			}

		}

		//System.out.println(content.toString());
		return content;
	}
}