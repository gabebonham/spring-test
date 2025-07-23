package com.grote.controller.omdb.facaes;

import com.grote.DTOs.OmdbParamsReq;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.DTOs.OmdbTitleRes;
import com.grote.impl.omdb.services.OmdbService;
import com.grote.mappers.OmdbParamsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OmdbControllerFacade {
    private OmdbService service;
    public OmdbSearchRes getSearch(OmdbParamsReq req){
        return service.getSearch(OmdbParamsMapper.mapToModel(req));
    }
    public OmdbTitleRes getTitle(OmdbParamsReq req){
        return service.getTitle(OmdbParamsMapper.mapToModel(req));
    }
}
