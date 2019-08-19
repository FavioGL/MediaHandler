package com.breakbot.media.tasks;

import com.breakbot.media.model.MediaFile;
import com.breakbot.media.model.MediaList;
import com.breakbot.media.step.FileProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class RenameFiles implements Tasklet {
    private static final Logger logger = LogManager.getLogger(RenameFiles.class);

    @Autowired
    private MediaList mediaList;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        logger.info("STARTING RENAMING ===========");
        for(MediaFile mediaFile : mediaList.getFileList()){
            logger.info(mediaFile.getFileName() + " >>>>> " + mediaFile.getFileNewPath() +  mediaFile.getFileNewName());
        }
        logger.info("total size:= " +  mediaList.getFileList().size());
        return RepeatStatus.FINISHED;
    }
}
