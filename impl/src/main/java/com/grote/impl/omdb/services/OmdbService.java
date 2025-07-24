package com.grote.impl.omdb.services;

import com.grote.DTOs.OmdbParamsIntegration;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.DTOs.OmdbTitleIntegration;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.integration.omdb.services.OmdbIntegrationService;
import com.grote.mappers.OmdbParamsMapper;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.mappers.OmdbTitleMapper;
import com.grote.models.OmdbParams;
import com.grote.models.OmdbSearch;
import com.grote.models.OmdbTitle;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OmdbService {
    private final OmdbIntegrationService service;
    public OmdbSearchRes getSearch(OmdbParams params){
        OmdbParamsIntegration paramsIntegration = OmdbParamsMapper.mapToIntegration(params);
        OmdbSearch search = service.getSearch(paramsIntegration);
        return OmdbSearchMapper.mapToRes(search);
    }
    public OmdbTitleRes getTitle(OmdbParams params){
        OmdbParamsIntegration paramsIntegration = OmdbParamsMapper.mapToIntegration(params);
        OmdbTitle title = service.getTitle(paramsIntegration);
        return OmdbTitleMapper.mapToRes(title);
    }
}
