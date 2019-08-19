package com.breakbot.media.model;

import lombok.Data;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class MediaList {
    private HashSet<MediaFile> fileList;
    private HashSet<MediaFile> duplicatedList;
    private HashSet<String> directorySet;
    private String comment;

    public HashSet<String> getDirectorySet() {
        return directorySet;
    }

    public void setDirectorySet(HashSet<String> directorySet) {
        this.directorySet = directorySet;
    }

    public MediaList() {
        fileList = new HashSet<>();
        duplicatedList = new HashSet<>();
        directorySet = new HashSet<>();
    }

    public HashSet<MediaFile> getFileList() {
        return fileList;
    }

    public void setFileList(HashSet<MediaFile> fileList) {
        this.fileList = fileList;
    }

    public HashSet<MediaFile> getDuplicatedList() {
        return duplicatedList;
    }

    public void setDuplicatedList(HashSet<MediaFile> duplicatedList) {
        this.duplicatedList = duplicatedList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
/*public MediaList() {
        fileList = new HashSet<>();
        duplicatedList = new HashSet<>();
    }*/
}
