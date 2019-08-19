package com.breakbot.media.model;

import lombok.Data;
/*breakbot 2019*/
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class MediaFile implements Serializable {
    private String fileName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MediaFile)) return false;
        MediaFile mediaFile = (MediaFile) o;
        return getFileName().equals(mediaFile.getFileName()) &&
                getFileType().equals(mediaFile.getFileType()) &&
                Objects.equals(getFileFullPath(), mediaFile.getFileFullPath()) &&
                getFileCreationDate().equals(mediaFile.getFileCreationDate()) &&
                Objects.equals(getTargetPath(), mediaFile.getTargetPath()) &&
                Objects.equals(getFileNewName(), mediaFile.getFileNewName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFileName(), getFileType(), getFileCreationDate());
    }

    private String fileType;
    private String fileFullPath;
    private Date fileCreationDate;
    private String targetPath;
    private String fileNewName;
    private float fileSize;
    private String fileNewPath;
}
