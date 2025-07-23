package com.grote.mappers;

import com.grote.DTOs.OmdbSearchIntegration;
import com.grote.DTOs.OmdbSearchRes;
import com.grote.models.OmdbSearch;

public class OmdbSearchMapper {
    public static OmdbSearch mapToModel(OmdbSearchIntegration integration){
        if (integration == null) return null;
        var entities = integration.getSearch().stream()
                .map(OmdbEntryMapper::mapToModel)
                .toList();
        return OmdbSearch.builder()
                .Search(entities)
                .build();
    }
    public static OmdbSearchRes mapToRes(OmdbSearch model){
        if (model == null) return null;
        var entities = model.getSearch().stream()
                .map(OmdbEntryMapper::mapToRes)
                .toList();
        return OmdbSearchRes.builder()
                .Search(entities)
                .build();
    }
}
