package com.grote.config;

import javax.cache.CacheManager;
import javax.cache.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager jCacheManager() {
        return Caching.getCachingProvider().getCacheManager();
    }
}
