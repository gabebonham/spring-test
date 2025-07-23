package com.grote.mappers;

import com.grote.DTOs.*;
import com.grote.models.OmdbParams;

public class OmdbParamsMapper {
    public static OmdbParams mapToModel(OmdbParamsReq req){
        return OmdbParams.builder()
                .s(req.getS())
                .y(req.getY())
                .type(req.getType())
                .page(req.getPage())
                .build();
    }
    public static OmdbParamsIntegration mapToIntegration(OmdbParams model){
        return OmdbParamsIntegration.builder()
                .s(model.getS())
                .y(model.getY())
                .type(model.getType())
                .page(model.getPage())
                .build();
    }
}
