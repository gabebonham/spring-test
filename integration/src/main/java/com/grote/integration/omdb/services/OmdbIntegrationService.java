package com.grote.integration.omdb.services;

import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.integration.omdb.feign.OmdbFeign;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.models.OmdbSearch;
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
}
