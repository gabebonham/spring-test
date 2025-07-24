package com.grote.controller.omdb.facaes;

import com.grote.DTOs.OmdbParamsReq;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.impl.omdb.services.OmdbService;
import com.grote.mappers.OmdbParamsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OmdbControllerFacade {
    private final OmdbService service;
    public OmdbSearchRes getSearch(OmdbParamsReq req){
        return service.getSearch(OmdbParamsMapper.mapToModel(req));
    }
    public OmdbTitleRes getTitle(OmdbParamsReq req){
        return service.getTitle(OmdbParamsMapper.mapToModel(req));
    }
}
