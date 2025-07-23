package com.grote.integration.omdb.services;

import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.integration.omdb.feign.OmdbFeign;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.mappers.OmdbTitleMapper;
import com.grote.models.OmdbSearch;
import com.grote.models.OmdbTitle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OmdbIntegrationService {
    @Value("${omdb.apiKey}")
    private String apiKey;
    private OmdbFeign feign;
    public OmdbIntegrationService(OmdbFeign feign){
        this.feign = feign;
    }
    public OmdbSearch getSearch(OmdbParamsIntegration params){
        var search = feign.getSearch(params.getS(),
                apiKey,
                params.getType(),
                params.getY(),
                params.getPage());
        return OmdbSearchMapper.mapToModel(search);
    }
    public OmdbTitle getTitle(OmdbParamsIntegration params){
        var search = feign.getTitle(params.getT(),
                apiKey,
                params.getType(),
                params.getY(),
                params.getPage());
        return OmdbTitleMapper.mapToModel(search);
    }
}
