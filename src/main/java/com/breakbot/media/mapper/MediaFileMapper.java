package com.breakbot.media.mapper;

import com.breakbot.media.model.MediaFile;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaFileMapper implements FieldSetMapper<MediaFile> {
    private static final Pattern p = Pattern.compile("\\d+\\.*");
    @Override
    public MediaFile mapFieldSet(FieldSet fieldSet) throws BindException {

        MediaFile mediaFile = new MediaFile();
        mediaFile.setFileFullPath(fieldSet.readString(0));
        mediaFile.setFileName(fieldSet.readString(1));
        try {
            mediaFile.setFileCreationDate(new SimpleDateFormat("yyyy:MM:dd H:m:s").parse(fieldSet.readString(2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mediaFile.setFileType(fieldSet.readString(3));
        Matcher m = p.matcher(fieldSet.readString(4));
        if(m.find())
            mediaFile.setFileSize(Float.parseFloat(m.group()));
        return mediaFile;
    }
}
