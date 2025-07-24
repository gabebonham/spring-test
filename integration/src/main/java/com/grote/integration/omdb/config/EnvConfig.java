package com.grote.integration.omdb.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

    @Value("${omdb.key}")
    private String omdbApiKey;

    @Value("${omdb.url}")
    private String omdbApiUrl;

    public String getOmdbApiKey() {
        return omdbApiKey;
    }

    public String getOmdbApiUrl() {
        return omdbApiUrl;
    }
}
