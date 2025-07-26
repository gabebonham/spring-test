package com.grote.integration.omdb.services;

import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbTitleIntegration;
import com.grote.integration.omdb.config.EnvConfig;
import com.grote.integration.omdb.feign.OmdbFeign;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.mappers.OmdbTitleMapper;
import com.grote.models.OmdbSearch;
import com.grote.models.OmdbTitle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class OmdbIntegrationService {
    private final OmdbFeign feign;
    private final EnvConfig env;
    @Cacheable("searchCache")
    public OmdbSearch getSearch(OmdbParamsIntegration params){
        OmdbSearchIntegration search = feign.getSearch(env.getOmdbApiKey(),
                params.getS(),
                params.getType(),
                params.getY(),
                params.getPage());
        if (Objects.nonNull(search) && !search.getSearch().isEmpty() ){
            log.info("Response fetched");
        } else {
            log.info("Response empty");
        }
        return OmdbSearchMapper.mapToModel(search);
    }
    @Cacheable("titleCache")
    public OmdbTitle getTitle(OmdbParamsIntegration params){
        OmdbTitleIntegration title = feign.getTitle(env.getOmdbApiKey(),
                params.getT(),
                params.getI(),
                params.getType(),
                params.getY(),
                "true",
                params.getPage());
        if (Objects.nonNull(title)){
            log.info("Response fetched");
        } else {
            log.info("Response empty");
        }
        return OmdbTitleMapper.mapToModel(title);
    }
}
