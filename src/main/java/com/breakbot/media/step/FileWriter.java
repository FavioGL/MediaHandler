package com.breakbot.media.step;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.breakbot.media.model.MediaFile;
import com.breakbot.media.model.MediaList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class FileWriter implements ItemWriter<MediaFile> {

	private static final Logger logger = LogManager.getLogger(FileWriter.class);
	@Autowired
	private MediaList mediaList;

	@Override
	public void write(List<? extends MediaFile> files) throws Exception {
		String newFileName;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		DateFormat dateFormatPath = new SimpleDateFormat("/yyyy/MM/dd/");
		//logger.info(mediaList);
		for (MediaFile mediaFile : files) {
			if (!mediaList.getFileList().contains(mediaFile)) {
				logger.info("Adding: " + mediaFile.getFileFullPath());
				newFileName = dateFormat.format(mediaFile.getFileCreationDate()) +  "_" +
						mediaFile.getFileName().substring(0, mediaFile.getFileName().lastIndexOf('.'))
						.replaceAll("[^A-Za-z0-9]","") +
						mediaFile.getFileName().substring(mediaFile.getFileName().lastIndexOf('.'), mediaFile.getFileName().length());
				mediaFile.setFileNewName(newFileName);
				String newPath = dateFormatPath.format(mediaFile.getFileCreationDate());
				mediaList.getDirectorySet().add(newPath);
				mediaFile.setFileNewPath( newPath);
				mediaList.getFileList().add(mediaFile);
			} else {
				if (!mediaList.getDuplicatedList().contains(mediaFile)) {
			 		logger.info("Adding DUPLICATED: " +   mediaFile.getFileFullPath());
					mediaList.getDuplicatedList().add(mediaFile);
				} else {
					logger.info("DISCARDED: " +   mediaFile.getFileFullPath());
				}

			}
		}


	}
	
}