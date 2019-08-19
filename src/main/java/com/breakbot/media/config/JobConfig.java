package com.breakbot.media.config;

import com.breakbot.media.model.MediaFile;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;

@Configuration
public class JobConfig {

   /* @Bean
    @JobScope
    public HashSet<MediaFile> mediaList(){
        System.out.println("mediaList");
        return new HashSet<>();
    }*/
}
