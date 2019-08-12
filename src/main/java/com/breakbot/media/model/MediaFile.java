package com.breakbot.media.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MediaFile implements Serializable {
    private String fileName;
    private String fileType;
    private String fileFullPath;
    private Date fileCreationDate;
    private String targetPath;
    private String fileNewName;
}
