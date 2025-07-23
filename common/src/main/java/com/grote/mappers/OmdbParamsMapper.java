package com.grote.mappers;

import com.grote.DTOs.*;
import com.grote.models.OmdbParams;

public class OmdbParamsMapper {
    public static OmdbParams mapToModel(OmdbParamsReq req){
        if (req == null) return null;
        return OmdbParams.builder()
                .s(req.getS())
                .y(req.getY())
                .type(req.getType())
                .page(req.getPage())
                .i(req.getI())
                .build();
    }
    public static OmdbParamsIntegration mapToIntegration(OmdbParams model){
        if (model == null) return null;
        return OmdbParamsIntegration.builder()
                .s(model.getS())
                .y(model.getY())
                .type(model.getType())
                .page(model.getPage())
                .i(model.getI())
                .build();
    }
}
