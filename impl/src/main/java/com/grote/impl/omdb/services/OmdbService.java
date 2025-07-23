package com.grote.impl.omdb.services;

import com.grote.DTOs.OmdbSearchRes;
import com.grote.integration.omdb.services.OmdbIntegrationService;
import com.grote.mappers.OmdbParamsMapper;
import com.grote.mappers.OmdbSearchMapper;
import com.grote.models.OmdbParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OmdbService {
    private OmdbIntegrationService service;
    public OmdbSearchRes getSearch(OmdbParams params){
        var paramsIntegration = OmdbParamsMapper.mapToIntegration(params);
        var search = service.getSearch(paramsIntegration);
        return OmdbSearchMapper.mapToRes(search);
    }
}
